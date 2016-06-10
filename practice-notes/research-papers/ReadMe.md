# Google Big Table for Distributed Data Storage
-----------------------------------------------

## Rows
Every read or write of data under a single row key is atomic (regardless of the number of different columns being read or written in the row), a
design decision that makes it easier for clients to reason about the system’s behavior in the presence of concurrent updates to the same row.

## Column Family
- All data stored in a column family is usually of the same type (we compress data in the same column family together). 
- Intent that number of different column families be small
- Families rarely change during operation

- Supports single row transactions. Atomic read-write-modify operations within a row
- Allows cells to be used as integer counters
- Allows client side scripts written in SawZall (Google language) to be executed on BT servers. It allows users to transform data, perform other operations on dta like filtering etc. But scripts are not allowed to write back to BT.
- Can be used as Input source as well as Output source for MapReduce

- Chubby: Distributed lock service
- PAXOS algorithm can be used to keep the replicas consistent

- Measured that when chubby is not available, BT is also not available. Hence, distributed lock service is must to have.

## Implementation
- Library for client
- 1 Master server
- Multiple Tablet servers

Client data does not go via Master. Instead client directly communicates to Tablet and pass its data to it.
In this sense, master is lightly loaded.

Heirarchy
1. Root Tablet
2. Metadata Tablets
3. User Tablets

## Tablet Assignment
- Server keeps a chubby directory and master is watching on it
- Whenever a Tablet Server starts, it creates a file in the directory and takes a lock on it.
- Whenever master has any unassigned tablet, it asks live tablet servers and assigns to one of them which has capaibility
- Master than asks it to make a request to loadTablet
- Master updates root tablet which contains metadata about each tablet and corresponding tablet server

## Tablet server goes down
- When master does not receive any response after certain attempts from a particular tablet server, it tries to gain lock on its chubby file
- If Tablet server is down, master should be able to take the lock which means master is able to reach chubby and tablet server is not.
- In this case, tablet server is killed and its tablets are reassigned by master
- If chubby session is expired, then master kills itself
- In this case no transfer of tablets is done
- New master is instantiated which takes a lock on chubby file to handle concurrent instantiations for master
- It reads root tablet to know about rest of the tablets information.

## Compaction
- Tablet Server maintains commit log and memtable which is the latest few operations on some tablets.
- When a read is performed, a read is done form memtable and read from SSTables (or HFiles) is merged and returned to user
- When a write is performed and commited, server adds this to its memtable and also writes to commit log.
- At some point, on write operation we won't be able to add more items to memtable because it has reached threshold. In this case 
the memtable is frozen and moved to disc as SSTable and new memtable is created.
- Commit log can be used to regenerate tablets
- At some point, we can have multiple SSTables and memtable. Results from SSTables and memtable have to be merged in some cases
- Hence, BigTable tries to reduce the number of disc files by removing deleted records and reducing the  records in each file and thereby merging the results and generating SSTables files again. This is called compaction.

## Refinements

1. *Group Locality*: Store related data locally which can be queried together. It means store column fammily data on the same machine.
2. *Bloom Filters:* Improve disk seeks
3.*Compression:* Two way compression of data. In case of webtable BMDiff was used which provided 10-1 size compression. Encoding and decoding was faster with BMDiff so compression can be good.
4. *Commit Log Implementation:* Master stores one log file per tablet server. When tablet server dies, its tablets are distributed to other tablet servers and they ask master to recover the tablets assigned to them. Master breaks down the commit log into 64MB files and ask the tablet servers to parallel merge-sort it as table, row, seguence log.
Now, it is easier for recovering a tablet as the rows are sorted and it minimizes the disk seeks.
5. *Immutable SSTables*: SSTables are immutable. Only memtables are mutable. It is the responsibility of Garbage Collector to remove/delete stale rows/sstables.

## Keywords
family:qualifier, PAXOS algorithm, 
