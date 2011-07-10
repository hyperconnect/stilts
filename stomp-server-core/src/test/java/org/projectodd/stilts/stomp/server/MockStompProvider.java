package org.projectodd.stilts.stomp.server;

import java.util.ArrayList;
import java.util.List;

import org.projectodd.stilts.stomp.Headers;
import org.projectodd.stilts.stomp.StompException;
import org.projectodd.stilts.stomp.spi.AcknowledgeableMessageSink;
import org.projectodd.stilts.stomp.spi.StompConnection;
import org.projectodd.stilts.stomp.spi.StompProvider;

public class MockStompProvider implements StompProvider {

    @Override
    public StompConnection createConnection(AcknowledgeableMessageSink messageSink, Headers headers) throws StompException {
        MockStompConnection connection = new MockStompConnection( "session-" + (++this.sessionCounter) );
        this.connections.add( connection );
        return connection;
    }
    
    public List<MockStompConnection> getConnections() {
        return this.connections;
    }
    
    private List<MockStompConnection> connections = new ArrayList<MockStompConnection>();
    private int sessionCounter = 0;

}
