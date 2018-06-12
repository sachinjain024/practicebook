import com.aerospike.client.{AerospikeClient, Bin, Key, Value}
import com.aerospike.client.policy.{Policy, WritePolicy}

object EmptyNullValuesTest {

  def main(args: Array[String]): Unit = {
    val aerospikeServerIp = "127.0.0.1"
    val aerospikeServerPort = 3000

    val client = new AerospikeClient(aerospikeServerIp, aerospikeServerPort)
    testForEmptyAndNullValues(client)
    client.close()
  }

  def testForEmptyAndNullValues(client: AerospikeClient): Unit = {
    // Write record
    val policy = new WritePolicy
    policy.timeout = 1000

    val key = new Key("test", "set", "name")

    val bin1 = new Bin("emptyStringCol", new Value.StringValue(""))
    val bin2 = new Bin("nullValue", new Value.NullValue)
    val bin3 = new Bin("nullValueAsStr", new Value.StringValue(null))

    client.put(policy, key, bin1, bin2, bin3)

    // Read record
    val readPolicy = new Policy
    val record = client.get(policy, key, "emptyStringCol", "nullValue", "nullValueAsStr", "notExistsColu")

    print(record)
  }
}
