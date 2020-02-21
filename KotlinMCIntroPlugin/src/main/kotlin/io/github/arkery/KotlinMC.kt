package io.github.arkery

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.io.IOException
import java.sql.Connection
import java.sql.DriverManager

class KotlinMC: JavaPlugin(), Listener, CommandExecutor{

    private val dbLocation: File = File(this.dataFolder, "test.db")
    private var connection: Connection? = null


    override fun onEnable() {
        println("Starting KotlinMC Plugin")

        try{

            if(!dbLocation.exists()){
                println("Attempting to create database")
                this.dataFolder.mkdir()
                this.dbLocation.createNewFile()
            }

            Class.forName("org.sqlite.JDBC")
            this.connection = DriverManager.getConnection("jdbc:sqlite:${this.dbLocation}")
            println("Created database at: ${dbLocation.absolutePath}")
        }catch (f: ClassNotFoundException){
            println("Missing JDBC Driver")
        }catch (g: IOException){
            println("Unable to create Folder")
        }

        Bukkit.getPluginManager().registerEvents(this, this)
    }

    override fun onDisable() {
        println("Closing the Plugin")
        this.connection?.close()
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