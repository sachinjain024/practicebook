import com.aerospike.client.AerospikeClient
import com.aerospike.client.Bin
import com.aerospike.client.Key
import com.aerospike.client.Value
import com.aerospike.client.policy.{Policy, WritePolicy}

object CaseSensitiveTest {

  def main(args: Array[String]): Unit = {
    // val aerospikeServerIp = "127.0.0.1"
    val aerospikeServerIp = "192.168.99.100"
    val aerospikeServerPort = 3000

    val client = new AerospikeClient(aerospikeServerIp, aerospikeServerPort)
    val key = new Key("test", "set", "name")

    writeCaseSensitiveBins(client, key)
    readRow(client, key)

  }

  def writeCaseSensitiveBins(client: AerospikeClient, key: Key): Unit = {
    val policy = new WritePolicy
    policy.timeout = 1000

    val key = new Key("test", "set", "name")

    val bin1 = new Bin("colname", new Value.StringValue("small case"))
    val bin2 = new Bin("COLNAME", new Value.StringValue("capital case"))
    val bin3 = new Bin("colName", new Value.StringValue("camel case"))

    client.put(policy, key, bin1)
    client.put(policy, key, bin2)
    client.put(policy, key, bin3)
  }

  def readRow(client: AerospikeClient, key: Key): Unit = {
    val policy = new Policy

    val record = client.get(policy, key)

    print(record)
  }
}