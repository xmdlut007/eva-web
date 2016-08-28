package com.cn.xm.common.utils;

import java.util.UUID;

/**
 * @author qiuwenming
 * @since 2016-08-18 下午8:29:31
 */

public class UuidUtil {
    public static final UUID UUID_EMPTY = new UUID(0, 0);

    public static byte[] bytesFromRandomUuid() {
        return uuidAsBytes(UUID.randomUUID());
    }

    public static byte[] bytesFromUuidString(String name) {
        return uuidAsBytes(UUID.fromString(name));
    }

    public static byte[] bytesFromUuidStringWithoutSeparator(String name) {
        name = uuidWithoutSeparatorToStandardUUID(name);
        if (name == null) {
            return null;
        }
        return uuidAsBytes(UUID.fromString(name));
    }

    private static String uuidWithoutSeparatorToStandardUUID(String uuid) {
        if (uuid.length() != 32) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(uuid.subSequence(0, 8)).append("-").append(uuid.substring(8, 12)).append("-").append(uuid.substring(12, 16))
                .append("-").append(uuid.substring(16, 20)).append("-").append(uuid.substring(20));
        return buffer.toString();
    }

    public static String stringFromUuidBytes(byte[] uuid) {
        return uuidFromBytes(uuid).toString();
    }

    public static byte[] uuidAsBytes(UUID uuid) {
        long msb = uuid.getMostSignificantBits();
        long lsb = uuid.getLeastSignificantBits();
        byte[] bytes = new byte[16];

        for (int i = 0; i < 8; i++) {
            bytes[i] = (byte) (msb >>> 8 * (7 - i));
        }

        for (int i = 8; i < 16; i++) {
            bytes[i] = (byte) (lsb >>> 8 * (15 - i));
        }

        return bytes;
    }

    public static UUID uuidFromBytes(byte[] uuid) {
        if (null == uuid) {
            return UUID_EMPTY;
        }

        long msb = 0;
        long lsb = 0;
        assert uuid.length == 16;
        for (int i = 0; i < 8; i++) {
            msb = (msb << 8) | (uuid[i] & 0xff);
        }

        for (int i = 8; i < 16; i++) {
            lsb = (lsb << 8) | (uuid[i] & 0xff);
        }

        return new UUID(msb, lsb);
    }
}
