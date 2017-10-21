package substitu.dota2api.model

/**
  * Created by ritter on 21-10-17.
  */
object LobbyType extends Enumeration {
  type LobbyType = Value
  val Invalid = Value(-1)
  val PublicMatchMaking = Value(0)
  val Practise = Value(1)
  val Tournament = Value(2)
  val Tutorial = Value(3)
  val CoopWithBots = Value(4)
  val TeamMatch = Value(5)
  val SoloQueue = Value(6)
  val Ranked = Value(7)
  val `1v1Mid` = Value(8)
}
