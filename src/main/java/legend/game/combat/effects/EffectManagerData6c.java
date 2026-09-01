package legend.game.combat.effects;

import legend.core.memory.Method;
import legend.game.combat.Battle;
import legend.game.combat.types.BattleObject;
import legend.game.scripting.ScriptState;
import org.joml.Vector3f;
import org.joml.Vector3i;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

public class EffectManagerData6c<T extends EffectManagerParams<T>> extends BattleObject implements AttachmentHost {
  public static final Pattern PATTERN = Pattern.compile("[\\\\/:*?\"<>|]");
  public final String name;

  /** The first 11 (or more?) bits denote which attachments this effect has */
  public int flags_04;
  /** The bobj that this effect is visually attached to */
  public int parentBobjIndex_0c;
  /** The bobj part that this effect is visually attached to */
  public int parentPartIndex_0d;
  public ScriptState<EffectManagerData6c<T>> myScriptState_0e;

  public final T params_10;
  public Effect<T> effect_44;
//  public BiConsumer<ScriptState<EffectManagerData6c<T>>, EffectManagerData6c<T>> ticker_48;
//  public BiConsumer<ScriptState<EffectManagerData6c<T>>, EffectManagerData6c<T>> destructor_4c;
  public ScriptState<EffectManagerData6c<?>> parentScript_50;
  public ScriptState<EffectManagerData6c<?>> childScript_52;
  /** If replacing a child, this is the old child's ID */
  public ScriptState<EffectManagerData6c<?>> oldChildScript_54;
  /** If replaced as a child, this is the new child's ID */
  public ScriptState<EffectManagerData6c<?>> newChildScript_56;
  /** A linked list of attachments */
  private EffectAttachment attachment_58;
  //  public String type_5c; Equivalent to "name" above
  public int loadingIndex = 0;
  public String realName = "";
  public String frameData = "";
  public int startFrame = 0;
  public int currentFrame = 0;
  public int endFrame = 0;
  public int paramsData = 0;

  public static <T extends EffectManagerParams<T>> Class<EffectManagerData6c<T>> classFor(final Class<T> cls) {
    return (Class<EffectManagerData6c<T>>)(Class<?>)EffectManagerData6c.class;
  }

  public EffectManagerData6c(final Battle battle, final String name, final T params, final int loadingIndex) {
    super(battle, BattleObject.EM__);
    this.name = name;
    this.params_10 = params;
    this.loadingIndex = loadingIndex;
  }

  public void setRealName(final String realName) {
    this.realName = realName;
  }

  public void setStartFrame(final int startFrame) {
    this.startFrame = startFrame;
  }

  public void setFrameData(final int frame, final String data) {
    this.currentFrame = frame;
    final String newData = frame + "," + data + ",\n";
    this.frameData += newData;
  }

  public void writeFrameData(final int frame, final String data) {
    this.endFrame = frame;
    this.setFrameData(frame, data);

    String safeFilename = "";
    if (Objects.equals(this.realName, "")) {
      safeFilename = "Main";
    } else {
      safeFilename = PATTERN.matcher(this.realName).replaceAll("_");
    }
    final String dumpFile = "D:\\TLoD_Modding\\DEFF_File_Mapping\\Dragoon-Captured\\4204-Dart_Red-Eyed_Dragoon_Transformation\\DeffParts\\" + safeFilename + ".csv";
    try (final BufferedWriter writer = new BufferedWriter(new FileWriter(dumpFile))) {
      final String headerDefaultData = "Manager,startFrame,endFrame,totalFrames,\n";
      final String headerData = safeFilename + ',' + this.startFrame + ',' + this.endFrame + ',' + (this.endFrame - this.startFrame) + '\n';
      writer.write(headerDefaultData);
      writer.write(headerData);
      final String transformDefaultData = "frameNumber,Translation,Rotation,Scale,\n";
      writer.write(transformDefaultData);
      writer.write(this.frameData);
      System.out.println("File: " + safeFilename + " successfully written...");
    } catch(IOException e) {
      System.out.println("WARNING!! - File: " + safeFilename + " FAILED TO BE WRITTEN!!!...");
    }
  }

  public void set(final EffectManagerData6c<T> other) {
    this.flags_04 = other.flags_04;
    this.parentBobjIndex_0c = other.parentBobjIndex_0c;
    this.parentPartIndex_0d = other.parentPartIndex_0d;
    this.myScriptState_0e = other.myScriptState_0e;
    this.params_10.set(other.params_10);
    this.effect_44 = other.effect_44;
    this.parentScript_50 = other.parentScript_50;
    this.childScript_52 = other.childScript_52;
    this.oldChildScript_54 = other.oldChildScript_54;
    this.newChildScript_56 = other.newChildScript_56;
    this.attachment_58 = other.attachment_58;
  }

  @Override
  public Vector3f getPosition() {
    return this.params_10.trans_04;
  }

  @Override
  public Vector3f getRotation() {
    return this.params_10.rot_10;
  }

  @Override
  public Vector3f getScale() {
    return this.params_10.scale_16;
  }

  @Override
  public Vector3i getColour() {
    return this.params_10.colour_1c;
  }

  public boolean hasAttachment(final int id) {
    return (this.flags_04 & 0x1 << id) != 0;
  }

  @Override
  public EffectAttachment getAttachment() {
    return this.attachment_58;
  }

  @Override
  public void setAttachment(final EffectAttachment attachment) {
    this.attachment_58 = attachment;
  }

  @Method(0x800e8dd4L)
  public <Attachment extends EffectAttachment> Attachment addAttachment(final int id, final int a2, final BiFunction<EffectManagerData6c<T>, Attachment, Integer> ticker, final Attachment attachment) {
    attachment.id_05 = id;
    attachment._06 = (short)a2;
    attachment.ticker_08 = (BiFunction)ticker;
    attachment.parent_00 = this.attachment_58;
    this.attachment_58 = attachment;
    this.flags_04 |= 0x1 << id;
    return attachment;
  }

  @Method(0x800e8c84L)
  public EffectAttachment findAttachment(final int id) {
    EffectAttachment attachment = this.attachment_58;

    while(attachment != null) {
      if(attachment.id_05 == id) {
        return attachment;
      }

      attachment = attachment.parent_00;
    }

    return null;
  }

  @Method(0x800e8d04L)
  public void removeAttachment(final int id) {
    AttachmentHost current = this;

    while(current.getAttachment() != null) {
      final EffectAttachment attachment = current.getAttachment();

      if(attachment.id_05 == id) {
        this.flags_04 &= ~(0x1 << id);
        current.setAttachment(attachment.getAttachment());
      } else {
        current = attachment;
      }
    }
  }
}
