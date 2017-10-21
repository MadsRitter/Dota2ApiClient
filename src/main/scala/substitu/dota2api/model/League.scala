package substitu.dota2api.model

/**
  * Created by ritter on 20-10-17.
  */

case class Leagues(leagues: Seq[League])
case class League(name: String, leagueId: Long, description: String, tournamentUrl: String, itemDef: Long)
