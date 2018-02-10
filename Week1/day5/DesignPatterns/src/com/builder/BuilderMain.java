package com.builder;

import static com.builder.NVidiaAdapter.*;

public class BuilderMain {
    public static void main(String[] args) {
        AdapterBuilder builder = new AdapterBuilder(1900, 1080, 32);

        builder.chainBehavior("FLIP").disableOcclusion(true);

        NVidiaAdapter nv = builder.build();

        System.out.println(nv);
        System.out.println();

        NVidiaAdapter nv2 = new AdapterBuilder(800, 600, 16).chainBehavior("SWAP").disableOcclusion(true).build();
        System.out.println(nv2);
    }
}
