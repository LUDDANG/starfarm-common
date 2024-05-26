package live.luya.starfarm.common.protocols.packets;

import live.luya.starfarm.common.protocols.PacketFieldsDescriber;

public abstract class SyncHUDInfoPacket implements PacketFieldsDescriber {
    public static final byte packetId = 0x01;

    // 소지금
    public long balance;

    // 별조각 개수
    public int countStarDusts;

    // 현재 피로도 (0 - 피로도 없음)
    public int stressNow;

    // 최대 피로도
    public int stressMax;
}
