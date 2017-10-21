package substitu.dota2api.model

import org.joda.time.DateTime

import scala.concurrent.duration.FiniteDuration

/**
  * Created by ritter on 20-10-17.
  */
case class MatchDetails(
                  players: Seq[MatchPlayer],
                  season: Option[_],
                  radiantWin: Boolean,
                  duration: FiniteDuration,
                preGameDuration: FiniteDuration,
                startTime: DateTime,
                matchId: Long,
                matchSeqNum: Long,
                firstBloodTime: FiniteDuration,
                lobbyType: LobbyType.LobbyType,
                humanPlayers: Int,
                leagueId: Long,
                positiveVotes: Int,
                negativeVotes: Int,
                gameMode: GameMode.GameMode,
                pickBans: Seq[PickBan],
                radiantTeam: Option[MatchTeam],
                direteam: Option[MatchTeam]
                )

case class MatchPlayer(
                        accountId: Long,
                        playerSlot: Int,
                        heroId: Int,
                        items: Map[String, Long],
                        backpack: Map[String, Long],
                        kills: Int,
                        deaths: Int,
                        assists: Int,
                        leaverStatus: Option[Int],
                        gold: Int,
                        lastHits: Int,
                        denies: Int,
                      goldPerMin: Int,
                      xpPerMin: Int,
                      goldSpent: Int,
                      heroDamage: Int,
                      towerDamage: Int,
                      heroHealing: Int,
                      level: Int,
                      abilityUpgrades: Option[Seq[AbilityUpgrade]]
                      ) extends Player
case class AbilityUpgrade(ability: Long, time: FiniteDuration, level: Int)

case class PickBan(isPick: Boolean, heroId: Int, team: Int, order: Int)

case class MatchTeam(id: Long, name: String, logo: Long)