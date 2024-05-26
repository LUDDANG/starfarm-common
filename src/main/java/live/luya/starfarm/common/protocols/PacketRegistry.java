package live.luya.starfarm.common.protocols;

import live.luya.starfarm.common.protocols.packets.OpeningStoreMetaPacket;
import live.luya.starfarm.common.protocols.packets.SyncHUDInfoPacket;

import java.lang.reflect.Field;
import java.util.logging.Logger;

public enum PacketRegistry {
    SYNC_HUD_INFO(SyncHUDInfoPacket.class, (byte) 0x01),
    OPEN_STORE_INFO(OpeningStoreMetaPacket.class, (byte) 0x02),
    ;

    final byte packetId;

    final Class<? extends PacketFieldsDescriber> clazz;

    PacketRegistry(
            Class<? extends PacketFieldsDescriber> clazz,
            byte packetId
    ) {
        this.clazz = clazz;
        this.packetId = packetId;
    }

    private static byte getPacketIdInClass(Class<? extends PacketFieldsDescriber> clazz) {
        try {
            Field field = clazz.getDeclaredField("packetId");
            field.setAccessible(true);
            return (byte) field.get(clazz);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return 0x0;
        }
    }

    public static byte getPacketId(Class<? extends PacketFieldsDescriber> clazz) {
        for (PacketRegistry registry : values()) {
            if (registry.clazz.equals(clazz)) {
                byte id = getPacketIdInClass(clazz);

                if (registry.packetId != id) {
                    Logger.getLogger(String.valueOf(PacketRegistry.class)).warning("Packet Class %s has mismatched mapping packetId=%d (registry has id=%d)".formatted(
                            clazz.getCanonicalName(),
                            id,
                            registry.packetId
                    ));
                }

                return registry.packetId;
            }
        }

        return 0x0;
    }
}

