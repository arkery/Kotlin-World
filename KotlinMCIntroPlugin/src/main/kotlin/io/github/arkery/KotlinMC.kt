package io.github.arkery

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class KotlinMC: JavaPlugin(), Listener, CommandExecutor{

    override fun onEnable() {
        println("Hello World")
    }

    override fun onDisable() {
        println("Closing the Plugin")
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            val player: Player = sender

            when(command.name){
                "Test" -> player.sendMessage("Hello World!")
                else -> player.sendMessage("Wrong command")
            }
        }
        else{
            sender.sendMessage("You must be a player to run commands")
        }

        return false
    }
}
