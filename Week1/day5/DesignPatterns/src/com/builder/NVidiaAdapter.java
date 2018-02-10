package com.builder;

public class NVidiaAdapter implements DisplayAdapter {

    //required fields
    private final int bufferWidth;
    private final int bufferHeight;
    private final int bitDepth;

    //optional
    private final String chainBehavior;
    private final boolean disableOcclusion;

    public static class AdapterBuilder {
        //required values
        private final int bufferWidth;
        private final int bufferHeight;
        private final int bitDepth;

        //optional
        private String chainBehavior;
        private boolean disableOcclusion;

        public AdapterBuilder(int bufferWidth, int bufferHeight, int bitDepth) {
            this.bufferWidth = bufferWidth;
            this.bufferHeight = bufferHeight;
            this.bitDepth = bitDepth;
        }

        public AdapterBuilder chainBehavior(String chainBehavior) {
            this.chainBehavior = chainBehavior;
            return this;
        }

        public AdapterBuilder disableOcclusion(boolean disable) {
            this.disableOcclusion = disable;
            return this;
        }

        public NVidiaAdapter build() {
            return new NVidiaAdapter(this);
        }
    }

    private NVidiaAdapter(AdapterBuilder builder) {
        bufferWidth = builder.bufferWidth;
        bufferHeight = builder.bufferHeight;
        bitDepth = builder.bitDepth;
        chainBehavior = builder.chainBehavior;
        disableOcclusion = builder.disableOcclusion;
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

    public boolean isDisableOcclusion() {
        return disableOcclusion;
    }

    @Override
    public String toString() {
        return "NVidiaAdapter{" +
                "bufferWidth=" + bufferWidth +
                ", bufferHeight=" + bufferHeight +
                ", bitDepth=" + bitDepth +
                ", chainBehavior='" + chainBehavior + '\'' +
                ", disableOcclusion=" + disableOcclusion +
                '}';
    }
}
