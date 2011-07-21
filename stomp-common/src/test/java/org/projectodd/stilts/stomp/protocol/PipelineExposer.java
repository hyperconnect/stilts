package org.projectodd.stilts.stomp.protocol;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelUpstreamHandler;

public class PipelineExposer implements ChannelUpstreamHandler, ChannelDownstreamHandler {

    private ChannelPipeline pipeline;

    public ChannelPipeline getPipeline() {
        return this.pipeline;
    }
    
    public Channel getChannel() {
        return this.pipeline.getChannel();
    }
    
    @Override
    public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        this.pipeline = ctx.getPipeline();
        ctx.getPipeline().remove( this );
    }

    @Override
    public void handleDownstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        this.pipeline = ctx.getPipeline();
        ctx.getPipeline().remove( this );
        
    }
}
