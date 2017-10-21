package substitu.dota2api.model

/**
  * Created by ritter on 21-10-17.
  */
trait Player {
  def accountId: Long
  def playerSlot: Int
  def heroId: Int
}
