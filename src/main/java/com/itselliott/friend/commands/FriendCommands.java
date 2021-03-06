package com.itselliott.friend.commands;

import com.itselliott.friend.options.Requests;
import com.itselliott.friend.options.State;
import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import com.sk89q.minecraft.util.commands.CommandPermissions;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Elliott on 29/08/2014.
 */
public class FriendCommands {
	
    @Command(
    		aliases = {"add"}, 
    		desc = "Request a friend!", 
    		usage = "[player] - The player to send a request to.", 
    		min = 1, 
    		max = 1)
    @CommandPermissions("friend.add")
    public static void add(CommandContext args, CommandSender sender) throws Exception {
        Player target = Bukkit.getPlayer(args.getString(0));
        Player player = (Player) sender;
        if(target != null){
            Requests.send(player, target);
        } else {
            State.StateMessage(player, State.StateType.INVALID_PLAYER, target);
        }
    }

    @Command(
    		aliases = {"accept"}, 
    		desc = "Accept a friend request", 
    		usage = "[player] - The player to accept a request", 
    		min = 1, 
    		max = 1)
    @CommandPermissions("friend.accept")
    public static void accept(CommandContext args, CommandSender sender) throws CommandException {
        Player target = Bukkit.getPlayer(args.getString(0));
        Player player = (Player) sender;
        if(target != null){
            Requests.accpet(player, target);
        }else {
            State.StateMessage(player, State.StateType.INVALID_PLAYER, target);
        }
    }



    @Command(
    		aliases = {"deny"}, 
    		desc = "Deny a friend request", 
    		usage = "[player] - The player to accept a request", 
    		min = 1, 
    		max = 1)
    public static void deny(CommandContext args, CommandSender sender) throws CommandException {
        Player target = Bukkit.getPlayer(args.getString(0));
        Player player = (Player) sender;
        if(target != null){
            Requests.deny(player, target);
        }else {
            State.StateMessage(player, State.StateType.INVALID_PLAYER, target);
        }
    }


}
