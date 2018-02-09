package com.Builder;

import com.sun.xml.internal.ws.api.server.Adapter;

public class NvidiaAdapter implements DisplayAdapter {

    //Required Fields
    private final int bufferWidth;
    private final int bufferHeight;
    private final int bitDepth;

    //Optional Fields
    private String chainBehavior;
    private boolean disalbeOcclusion;

    public static class AdapterBuilder {

        //Required Fields
        private final int bufferWidth;
        private final int bufferHeight;
        private final int bitDepth;

        //Optional Fields
        private String chainBehavior;
        private boolean disalbeOcclusion;

        public AdapterBuilder(int bufferWidth, int bufferHeight, int bitDepth){

            this.bufferWidth = bufferWidth;
            this.bufferHeight = bufferHeight;
            this.bitDepth = bitDepth;

        }

        public AdapterBuilder chainBehavior(String chainBehavior){

            this.chainBehavior = chainBehavior;
            return this;

        }

        public AdapterBuilder disableOcclusion(boolean disable){

            this.disalbeOcclusion = disable;
            return this;

        }

        public NvidiaAdapter build(){

            return new NvidiaAdapter(this);

        }

    }

    private NvidiaAdapter(AdapterBuilder builder){

        bufferWidth = builder.bufferWidth;
        bufferHeight = builder.bufferHeight;
        bitDepth = builder.bitDepth;
        chainBehavior = builder.chainBehavior;
        disalbeOcclusion = builder.disalbeOcclusion;

    }

    public int getBufferWidth() {

        return bufferWidth;

    }

    public int getBufferHeight() {

        return bufferHeight;

    }

    public int getBitDepth() {

        return bitDepth;

    }

    public String getChainBehavior() {

        return chainBehavior;

    }

    public boolean isDisalbeOcclusion() {

        return disalbeOcclusion;

    }

    @Override
    public String toString() {

        return "NvidiaAdapter{" +
                "bufferWidth=" + bufferWidth +
                ", bufferHeight=" + bufferHeight +
                ", bitDepth=" + bitDepth +
                ", chainBehavior='" + chainBehavior + '\'' +
                ", disalbeOcclusion=" + disalbeOcclusion +
                '}';

    }

}
