package substitu.dota2api.model

import org.joda.time.DateTime

/**
  * Created by ritter on 21-10-17.
  */
case class MatchHistories(
                           matches: Seq[MatchHistory], //A list of matches.
                           numResults: Int, //The number of matches in this response.
                           totalResults: Int, //The total number of matches for the query.
                           remainingResults: Int, //The number of matches left for this query.
                           status: Int,
                           statusDetail: Option[String] //A message explaining the status, should status not be 1.
                         )

case class MatchHistory(
                         matchId: Long, //The matches unique ID.
                         matchSeqNum: Long, //A 'sequence number', representing the order in which matches were recorded.
                         startTime: DateTime, //Unix timestamp of when the match began.
                         lobbyType: LobbyType.LobbyType,
                         players: Seq[MatchHistoryPlayer], //The list of players within the match.
                       seriesId: Option[Long],
                       seriesType: Option[Int],
                       radiantTeamId: Option[Long],
                       direTeamId: Option[Long]
                       )

case class MatchHistoryPlayer(
                               accountId: Long, //32-bit account ID.
                               playerSlot: Int,
                               heroId: Int //The hero's unique ID. A list of hero IDs can be found via the GetHeroes method.
                             ) extends Player