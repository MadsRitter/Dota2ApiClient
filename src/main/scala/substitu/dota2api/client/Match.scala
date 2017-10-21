package substitu.dota2api.client

import org.joda.time.DateTime
import substitu.dota2api.model.GameMode.GameMode
import substitu.dota2api.model.{Leagues, MatchDetails, MatchHistories}

import scala.concurrent.Future

/**
  * Created by ritter on 16-09-17.
  */
trait Match extends ApiBase{
  override private[client] val apiUrl = "IDOTA2Match_370"

  def getLeagueListing(
                        language: Option[String] = None
                      ): Future[Leagues]
  def getLiveLeagueGames(): Future[_]
  def getMatchDetails(
                       matchId: String
                     ): Future[MatchDetails]
  def getMatchHistory(
                       heroId: Option[Int] = None, //A list of hero IDs can be found via the GetHeroes method.
                       gameMode: Option[GameMode] = None,
                       skill: Option[Int] = None, //Skill bracket for the matches (Ignored if an account ID is specified).
                       minPlayers: Option[String] = None, //Minimum amount of players in a match for the match to be returned.
                       accountId: Option[Long] = None, //32-bit account ID.
                       leagueId: Option[Long] = None, //Only return matches from this league. A list of league IDs can be found via the GetLeagueListing method.
                       startAtMatchId: Option[Long] = None, //Start searching for matches equal to or older than this match ID.
                       matchesRequested: Option[Int] = None, //Amount of matches to include in results (default: 25).
                       tournamentGamesOnly: Option[Int] //Whether to limit results to tournament matches. (0 = false, 1 = true)
                     ): Future[MatchHistories]

  def getMatchHistoryBySequenceNum(
                                  startMatchAtSequenceNum: Option[Long] = None, //The match sequence number to start returning results from.
                                  matchesRequested: Option[Int] = None //The amount of matches to return.
                                  )

  def getScheduledLeagueGames(
                             dateMin: Option[DateTime] = None,
                             dateMax: Option[DateTime] = None
                             )

  def getTeamInfoByTeamID(
                           startAtTeamId: Option[Long] = None,
                           teamsRequested: Option[Int]
                         )

  def getTournamentPlayerStats(
                              accountId: Long, //32-bit account ID.
                              leagueId: Option[Long] = None, //A list of league IDs can be found via the GetLeagueListing method. Will return status 8 - only supports tournament 65006 (The International) unless you provide 65006.
                              heroId: Option[Int] = None //A list of hero IDs can be found via the GetHeroes method.
                              )
}
