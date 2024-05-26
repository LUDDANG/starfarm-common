package live.luya.starfarm.common.protocols.packets;

import live.luya.starfarm.common.protocols.PacketFieldsDescriber;

import java.util.List;

public abstract class OpeningStoreMetaPacket implements PacketFieldsDescriber {
    public static final byte packetId = 0x02;

    // 상점 이름
    public String storeName;

    // 상점 유형 (true=판매 / false=구매)
    public boolean isSelling;

    // 상품 개수
    public Integer entryCount;

    // 상품 목록
    public List<StoreEntry> entryList;

    public static class StoreEntry {
        // nbt 태그 -> net.minecraft.world.item.ItemStack.a((NBTTagCompound) MojangsonParser.a(nbt))
        public String nbt;

        // 거래 금액 (판매 혹은 구매)
        public Integer balance;
    }
}
