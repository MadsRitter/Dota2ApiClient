package substitu.dota2api.model

/**
  * Created by ritter on 21-10-17.
  */
object GameMode extends Enumeration {
  type GameMode = Value
  val None = Value(0)
  val AllPick = Value(1)
  val CaptainsMode = Value(2)
  val RandomDraft = Value(3)
  val SingleDraft = Value(4)
  val AllRandom = Value(5)
  val Intro = Value(6)
  val DireTide = Value(7)
  val ReverseCaptainsMode = Value(8)
  val TheGreeviling = Value(9)
  val Tutorial = Value(10)
  val MidOnly = Value(11)
  val LeastPlayed = Value(12)
  val NewPlayerPool = Value(13)
  val CompendiumMatchmaking = Value(14)
  val CoopVsBots = Value(15)
  val CaptainsDraft = Value(16)
  val AbilityDraft = Value(18)
  val AllRandomDeathmatch = Value(20)
  val `1v1MidOnly` = Value(21)
  val RankedMatchMaking = Value(22)
}