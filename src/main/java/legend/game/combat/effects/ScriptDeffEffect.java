package legend.game.combat.effects;

import legend.game.combat.Battle;
import legend.game.combat.SEffe;
import legend.game.scripting.ScriptState;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static legend.game.EngineStates.currentEngineState_8004dd04;

public class ScriptDeffEffect implements Effect<EffectManagerParams.VoidType> {
  @Override
  public void tick(final ScriptState<EffectManagerData6c<EffectManagerParams.VoidType>> state) {
    ((Battle)currentEngineState_8004dd04).scriptDeffTicker(state, state.innerStruct_00);
  }

  @Override
  public void render(final ScriptState<EffectManagerData6c<EffectManagerParams.VoidType>> state) {

  }

  @Override
  public void destroy(final ScriptState<EffectManagerData6c<EffectManagerParams.VoidType>> state) {
    if (((Battle)currentEngineState_8004dd04).isDeffDump) {
      try {
        final String deffFinal = ((Battle)currentEngineState_8004dd04).deffHeadData + ", Total Frames: " + ((Battle)currentEngineState_8004dd04).loadedDeff_800c6938.frameCount_20 + '\n' + ((Battle)currentEngineState_8004dd04).deffTimings;
        Files.writeString(Path.of("D:\\TLoD_Modding\\DEFF_File_Mapping\\Dragoon-Captured\\4204-Dart_Red-Eyed_Dragoon_Transformation\\4204-Dart_Red-Eyed_Dragoon_Transformation.txt"), deffFinal);
        System.out.println("DEFF Final File successfully created...");
      } catch(final IOException e) {
        System.out.println("An error occurred while writing.");
        e.printStackTrace();
      }

      ((Battle)currentEngineState_8004dd04).isDeffDump = false;
    }
    ((Battle)currentEngineState_8004dd04).scriptDeffDeallocator(state, state.innerStruct_00);
  }
}
