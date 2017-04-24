package org.ssms.utils;

import java.util.UUID;

/**
 * Created by Intellij IDEA
 * USER: luoliang
 * DATE: 2017/4/18
 * TIME: 下午11:26
 */
public class UUIDGenerator {
    public static String generatorId() {
        String uuid = UUID.randomUUID().toString();

        return uuid.replace("-", "").substring(0, 5);
    }
}
