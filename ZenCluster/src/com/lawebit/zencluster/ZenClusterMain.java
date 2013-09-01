package com.lawebit.zencluster;

import java.io.IOException;

import com.esotericsoftware.kryonet.Server;
import com.lawebit.zencluster.protocol.Protocol;

public class ZenClusterMain {
	public static void main(String [] args) throws IOException{
		int oListenPort = 3304;
		
		
		
		for( int i = 0; i < args.length; i++ ){
			String arg = args[i];
			if( arg.equals("--listen") )
				oListenPort = Integer.parseInt(args[i+1]);
		}
		
		Server server = new Server();
		Protocol.registerAll(server.getKryo());
		server.bind(oListenPort);
		
		
		boolean running = true;
		while( running ){
			server.update(200);
		}
	}
}
