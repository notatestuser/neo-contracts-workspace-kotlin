package contracts;

import org.neo.smartcontract.framework.SmartContract
import org.neo.smartcontract.framework.services.neo.Storage

class Contract : SmartContract() {
   fun Main(operation: String?, vararg args: Object) : Object? {
      // cleaner `when` not currently supported by the compiler :(
      if (operation == "Op1") {
         return op1(operation) as Object?

      } else if (operation == "Op2") {
         return op2(operation) as Object?

      } else {
         return false as Object?
      }
   }

   private fun op1(op: String?): Boolean {
      Storage.put(Storage.currentContext(), "Greeting to the World", "Hello World!")
      return true
   }

   private fun op2(op: String?): ByteArray? {
      return Storage.get(Storage.currentContext(), "Greeting to the World")
   }
}
