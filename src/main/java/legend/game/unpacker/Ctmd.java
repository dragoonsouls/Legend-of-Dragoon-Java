package legend.game.unpacker;

import legend.core.MathHelper;
import legend.core.gte.SVECTOR;

import java.util.ArrayList;
import java.util.List;

public class Ctmd {
  public final int flags;
  public final int objCount;
  public final ObjTable[] objTables;

  public Ctmd(final FileData data) {
    this.flags = (int)MathHelper.get(data.data(), data.offset() + 0x4, 4);
    this.objCount = (int)MathHelper.get(data.data(), data.offset() + 0x8, 4);
    this.objTables = new ObjTable[this.objCount];

    for(int i = 0; i < this.objCount; i++) {
      this.objTables[i] = new ObjTable(
        (int)MathHelper.get(data.data(), data.offset() + 0xc + i * 0x1c       , 4),
        (int)MathHelper.get(data.data(), data.offset() + 0xc + i * 0x1c + 0x04, 4),
        (int)MathHelper.get(data.data(), data.offset() + 0xc + i * 0x1c + 0x08, 4),
        (int)MathHelper.get(data.data(), data.offset() + 0xc + i * 0x1c + 0x0c, 4),
        (int)MathHelper.get(data.data(), data.offset() + 0xc + i * 0x1c + 0x10, 4),
        (int)MathHelper.get(data.data(), data.offset() + 0xc + i * 0x1c + 0x14, 4),
        (int)MathHelper.get(data.data(), data.offset() + 0xc + i * 0x1c + 0x18, 4)
      );
    }
  }

  public static class ObjTable {
    public final int vertices_00;
    public final int vertexCount_04;
    public final int normals_08;
    public final int normalCount_0c;
    public final int primitives_10;
    public final int primitiveCount_14;
    public final int scale_18;

    public final List<PrimitiveGroup> unpackedPrimitives = new ArrayList<>();
    public SVECTOR[] unpackedVertices;
    public final SVECTOR[] unpackedNormals;

    public ObjTable(final int vertices, final int vertexCount, final int normals, final int normalCount, final int primitives, final int primitiveCount, final int scale18) {
      this.vertices_00 = vertices;
      this.vertexCount_04 = vertexCount;
      this.normals_08 = normals;
      this.normalCount_0c = normalCount;
      this.primitives_10 = primitives;
      this.primitiveCount_14 = primitiveCount;
      this.scale_18 = scale18;

      this.unpackedNormals = new SVECTOR[normalCount];
    }
  }

  public record PrimitiveGroup(int header, byte[][] data) { }
}
