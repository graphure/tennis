# language: fr

Fonctionnalité: Calculer le score du match de tennis

  Plan du scénario: echange entre joueurs
    Etant donné que le démarrage du match
    Quand j'entre la commande <cmd>
    Alors le jeux affiche le message suivant : <message>

    Exemples:
      | cmd      | message                                                                                                                                                                                                                                         |
      | A        | 'Player A : 15 / Player B : 0\n'                                                                                                                                                                                                                |
      | AB       | 'Player A : 15 / Player B : 0\nPlayer A : 15 / Player B : 15\n'                                                                                                                                                                                 |
      | ABAAA    | 'Player A : 15 / Player B : 0\nPlayer A : 15 / Player B : 15\nPlayer A : 30 / Player B : 15\nPlayer A : 40 / Player B : 15\nPlayer A wins the game'                                                                                             |
      | ABABABAA | 'Player A : 15 / Player B : 0\nPlayer A : 15 / Player B : 15\nPlayer A : 30 / Player B : 15\nPlayer A : 30 / Player B : 30\nPlayer A : 40 / Player B : 30\nPlayer A : 40 / Player B : 40\nPlayer A : 40 / Player B : 40\nPlayer A wins the game' |

