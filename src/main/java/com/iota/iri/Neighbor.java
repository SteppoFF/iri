package com.iota.iri;

import java.net.*;

import com.iota.iri.service.Node;

public class Neighbor {

    private final SocketAddress address;
    
    public int numberOfAllTransactions, numberOfNewTransactions, numberOfInvalidTransactions;

    public Neighbor(final SocketAddress address) {
        this.address = address;
    }

    public void send(final DatagramPacket packet) {

        try {
            packet.setSocketAddress(address);
            Node.socket.send(packet);
        } catch (final Exception e) {
        	// ignore
        }
    }

    @Override
    public String toString() {

        return "\"address\": \"" + address + "\""
                + ", \"numberOfAllTransactions\": " + numberOfAllTransactions
                + ", \"numberOfNewTransactions\": " + numberOfNewTransactions
                + ", \"numberOfInvalidTransactions\": " + numberOfInvalidTransactions;
    }
    
    @Override
    public boolean equals(final Object obj) {
        return address.equals(((Neighbor)obj).address);
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }
    
    public SocketAddress address() {
		return address;
	}
}