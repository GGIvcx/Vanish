![Title](https://cdn.modrinth.com/data/cached_images/bc255a6940ee58b4974530854bc34fd8bf782420.png)
# What does the Plugin do?
This plugin gives you an easy to use and still customisable vanish system for your Minecraft Server.

# Currently supportet Versions by the repo
- Spigot/Paper/Bukkit 1.21.8

# Features
- Vanished players are remembered (even after server restarts!)
- Suffix over head of vanished players (toggleable & customisable)
- Particles when switching to and from vanish (toggleable)
- See vanished players (If required permissions are met)
- Toggle vanish for other players (If required permissions are met)
- All permissions are customisable

# Information
- This plugin does **not** change the player preview from the server list. Vanished players are still visible there. Try turning the preview list off if this bothers you or disabling the reporting of playernames.

## Permissions and Commands
| **Commands**        |**Description**          | **Permissions**       |
|---------------------|-------------------------|-----------------------|
| /v                  | Vanish yourself         | Vanish.use            |
| /vanish             | Vanish yourself         | Vanish.use            |
| /v (Player)         | Vanish other players    | Vanish.others         |
| /vanish (Player)    | Vanish other players    | Vanish.others         |

## Passive permissions
|**Description**          | **Permissions**       |
|-------------------------|-----------------------|
| See vanished players    | Vanish.seeOthers      |

## Config file
```
Vanish:
  System:
    Prefix: '&eVanish &8>'
  User:
    Suffix: '&8[&eV&8]'
  Settings:
    EnableParticles: true
    EnableItemPickup: false
    EnableMobTarget: false
    EnableSuffix: true
  Permissions:
    Use: Vanish.use
    UseOnOthers: Vanish.others
    SeeVanished: Vanish.seeOthers

```
### Explanation
- **Prefix** = The Prefix the plugin uses in chat
- **Suffix** = The Suffix used in the name of vanished players
- **EnableParticles** = Use particles when switching to an from vanish
- **EnableItemPickup** = If players should be able to pick up items when vanished
- **EnableMobTarget** = If players should be targetet by mobs when vanished
- **EnableSuffix** = If the Suffix should be used
- **Use** = Permission required for use of the vanish command
- **UseOnOthers** = Permission required for use of the vanish command on other players
- **SeeVanished** = Permission required to see other vanished players
