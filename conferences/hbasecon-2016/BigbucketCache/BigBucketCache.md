BigBucket Cache
---------------

- By default block cache is enabled and is 40% of heap
- hbase.bucketcache.size
- Bucket cache Not on by default
- We can also open each region server UI as well at port 16020
- Performs best with SSDs
- Kind of prefetching
- Prefetch faster wehn starting with an empty bucket cache then starting with leftovers
- HTRACE
- SystemTap to get file format of bucket cache
- HBASE-15240
- hbase.ui.blockcache.by.file.max limit is hit by blockcahce
- hortonworks.com/bloghbase-blockcache-101/