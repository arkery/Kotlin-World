package io.github.arkery

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File
import java.sql.Connection
import java.sql.SQLException

object Users : Table() {
    val id = varchar("id", 10) // Column<String>
    val name = varchar("name", length = 50) // Column<String>

    override val primaryKey = PrimaryKey(id, name = "PK_User_ID") // name is optional here
}

fun dbCreate(){
    try{
        val createHere = File("C:\\Users\\arker\\Desktop", "data.db")
        if(!createHere.exists()){
            createHere.createNewFile()
        }
        Database.connect("jdbc:sqlite:$createHere", "org.sqlite.JDBC")
        println("Connected to driver")
    }catch(e: Exception){
        e.printStackTrace()
    }
}

fun main() {
    dbCreate()
    transaction(Connection.TRANSACTION_SERIALIZABLE, 10) {
        SchemaUtils.createMissingTablesAndColumns(Users)
        try{
            Users.insert {
                it[id] = "arkery"
                it[name] = "arkery"
            }
        }catch (e: SQLException){
            Users.update({Users.id eq "arkery"}) {
                it[id] = "arkery"
                it[name] = "arkery" }
        }

        for(user in Users.selectAll()){
            println("ID: ${user[Users.id]}, Name: ${user[Users.name]}")
        }
    }
}

