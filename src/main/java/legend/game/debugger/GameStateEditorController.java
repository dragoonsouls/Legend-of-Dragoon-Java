package legend.game.debugger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import legend.game.modding.coremod.CoreMod;
import legend.game.types.GameState52c;

import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public class GameStateEditorController {

  String[] characters = {"Dart", "Lavitz", "Shana", "Rose", "Haschel", "Albert", "Meru", "Kongol", "???"};
  String[] characterData = {"EXP", "Party Flags", "HP", "MP", "SP", "Dragoon EXP", "Status", "Level", "Dragoon Level", "Equipment Slot 1", "Equipment Slot 2", "Equipment Slot 3", "Equipment Slot 4", "Equipment Slot 5", "Addition", "Addition Level Slot 1", "Addition Level Slot 2", "Addition Level Slot 3", "Addition Level Slot 4", "Addition Level Slot 5", "Addition Level Slot 6", "Addition Level Slot 7", "Addition Level Slot 8", "Addition EXP Slot 1", "Addition EXP Slot 2", "Addition EXP Slot 3", "Addition EXP Slot 4", "Addition EXP Slot 5", "Addition EXP Slot 6", "Addition EXP Slot 7", "Addition EXP Slot 8"};
  @FXML
  public TextField textData1;
  @FXML
  public ComboBox getScriptData;
  @FXML
  public TextField textScriptData;
  @FXML
  public ComboBox getParty;
  @FXML
  public TextField textParty;
  @FXML
  public TextField textGold;
  @FXML
  public TextField textChapter;
  @FXML
  public TextField textStardust;
  @FXML
  public TextField textTimestamp;
  @FXML
  public TextField textSubmapScene;
  @FXML
  public TextField textSubmapCut;
  @FXML
  public TextField textScriptEngine1;
  @FXML
  public TextField textScriptEngine2;
  @FXML
  public TextField textScriptEngine3;
  @FXML
  public ComboBox getScriptFlags1;
  @FXML
  public TextField textScriptFlags1;
  @FXML
  public ComboBox getScriptFlags2;
  @FXML
  public TextField textScriptFlags2;
  @FXML
  public ComboBox getData2;
  @FXML
  public TextField textData2;
  @FXML
  public ComboBox getData3;
  @FXML
  public TextField textData3;
  @FXML
  public ComboBox getGoods;
  @FXML
  public TextField textGoods;
  @FXML
  public ComboBox getData4;
  @FXML
  public TextField textData4;
  @FXML
  public ComboBox getChestFlags;
  @FXML
  public TextField textChestFlags;
  @FXML
  public Spinner getEquipment;
  @FXML
  public TextField textEquipment;
  @FXML
  public Spinner getItems;
  @FXML
  public TextField textItems;
  @FXML
  public ComboBox getCharacter;
  @FXML
  public ComboBox getCharacterData;
  @FXML
  public TextField textCharacterData;
  @FXML
  public ComboBox getData5;
  @FXML
  public TextField textData5;
  @FXML
  public TextField textPathIndex;
  @FXML
  public TextField textDotIndex;
  @FXML
  public TextField textDotOffset;
  @FXML
  public TextField textFacing;
  @FXML
  public TextField textAreaIndex;

  public void initialize() {
    this.textData1.setText(String.valueOf(gameState_800babc8._04));

    for(int i = 0; i < 0x20; i++) {
      this.getScriptData.getItems().add(i);
    }
    this.getScriptData.getSelectionModel().select(0);
    this.getScriptData();

    for(int i = 0; i < 3; i++) {
      this.getParty.getItems().add(i);
    }
    this.getParty.getSelectionModel().select(0);
    this.getParty();

    this.textGold.setText(String.valueOf(gameState_800babc8.gold_94));
    this.textChapter.setText(String.valueOf(gameState_800babc8.chapterIndex_98));
    this.textStardust.setText(String.valueOf(gameState_800babc8.stardust_9c));
    this.textTimestamp.setText(String.valueOf(gameState_800babc8.timestamp_a0));
    this.textSubmapScene.setText(String.valueOf(gameState_800babc8.submapScene_a4));
    this.textSubmapCut.setText(String.valueOf(gameState_800babc8.submapCut_a8));
    this.textScriptEngine1.setText(String.valueOf(gameState_800babc8._b0));
    this.textScriptEngine2.setText(String.valueOf(gameState_800babc8._b4));
    this.textScriptEngine3.setText(String.valueOf(gameState_800babc8._b8));

    for(int i = 0; i < 0x20; i++) {
      this.getScriptFlags1.getItems().add(i);
    }
    this.getScriptFlags1.getSelectionModel().select(0);
    this.getScriptFlags1();

    for(int i = 0; i < 8; i++) {
      this.getScriptFlags2.getItems().add(i);
    }
    this.getScriptFlags2.getSelectionModel().select(0);
    this.getScriptFlags2();

    for(int i = 0; i < 8; i++) {
      this.getData2.getItems().add(i);
    }
    this.getData2.getSelectionModel().select(0);
    this.getData2();

    for(int i = 0; i < 8; i++) {
      this.getData3.getItems().add(i);
    }
    this.getData3.getSelectionModel().select(0);
    this.getData3();

    this.getGoods.getItems().add(0);
    this.getGoods.getItems().add(1);
    this.getGoods.getSelectionModel().select(0);
    getGoods();

    for(int i = 0; i < 8; i++) {
      this.getData4.getItems().add(i);
    }
    this.getData4.getSelectionModel().select(0);
    this.getData4();

    for(int i = 0; i < 8; i++) {
      this.getChestFlags.getItems().add(i);
    }
    this.getChestFlags.getSelectionModel().select(0);
    this.getChestFlags();

    this.getEquipment.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 254, 0));
    this.getEquipment.valueProperty().addListener((observable, oldValue, newValue) -> {
      if(oldValue != newValue) {
        getEquipment();
      }
    });
    getEquipment();

    this.getItems.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, gameState_800babc8.getConfig(CoreMod.INVENTORY_SIZE_CONFIG.get()), 0));
    this.getItems.valueProperty().addListener((observable, oldValue, newValue) -> {
      if(oldValue != newValue) {
        getItems();
      }
    });
    getItems();

    for(int i = 0; i < characters.length; i++) {
      this.getCharacter.getItems().add(characters[i]);
    }
    this.getCharacter.getSelectionModel().select(0);

    for(int i = 0; i < characterData.length; i++) {
      this.getCharacterData.getItems().add(characterData[i]);
    }
    this.getCharacterData.getSelectionModel().select(0);
    getCharacter();

    for(int i = 0; i < 8; i++) {
      this.getData5.getItems().add(i);
    }
    this.getData5.getSelectionModel().select(0);
    this.getData5();

    this.textPathIndex.setText(String.valueOf(gameState_800babc8.pathIndex_4d8));
    this.textDotIndex.setText(String.valueOf(gameState_800babc8.dotIndex_4da));
    this.textDotOffset.setText(String.valueOf(gameState_800babc8.dotOffset_4dc));
    this.textFacing.setText(String.valueOf(gameState_800babc8.facing_4dd));
    this.textAreaIndex.setText(String.valueOf(gameState_800babc8.areaIndex_4de));
  }

  @FXML
  public void getData1() {
    this.textData1.setText(String.valueOf(gameState_800babc8._04));
  }

  @FXML
  public void setData1() {
    gameState_800babc8._04 = Integer.valueOf(this.textData1.getText());
  }

  @FXML
  public void getScriptData() {
    this.textScriptData.setText(String.valueOf(gameState_800babc8.scriptData_08[this.getScriptData.getSelectionModel().getSelectedIndex()]));
  }

  @FXML
  public void setScriptData() {
    gameState_800babc8.scriptData_08[this.getScriptData.getSelectionModel().getSelectedIndex()] = Integer.valueOf(this.textScriptData.getText());
  }

  @FXML
  public void getParty() {
    this.textParty.setText(String.valueOf(gameState_800babc8.charIds_88[this.getParty.getSelectionModel().getSelectedIndex()]));
  }

  @FXML
  public void setParty() {
    gameState_800babc8.charIds_88[this.getParty.getSelectionModel().getSelectedIndex()] = Integer.valueOf(this.textParty.getText());
  }

  @FXML
  public void getGold() {
    this.textGold.setText(String.valueOf(gameState_800babc8.gold_94));
  }

  @FXML
  public void setGold() {
    gameState_800babc8.gold_94 = Integer.valueOf(this.textGold.getText());
  }

  @FXML
  public void getChapter() {
    this.textChapter.setText(String.valueOf(gameState_800babc8.chapterIndex_98));
  }

  @FXML
  public void setChapter() {
    gameState_800babc8.chapterIndex_98 = Integer.valueOf(this.textChapter.getText());
  }

  @FXML
  public void getStardust() {
    this.textStardust.setText(String.valueOf(gameState_800babc8.stardust_9c));
  }

  @FXML
  public void setStardust() {
    gameState_800babc8.stardust_9c = Integer.valueOf(this.textStardust.getText());
  }

  @FXML
  public void getTimestamp() {
    this.textTimestamp.setText(String.valueOf(gameState_800babc8.timestamp_a0));
  }

  @FXML
  public void setTimestamp() {
    gameState_800babc8.timestamp_a0 = Integer.valueOf(this.textTimestamp.getText());
  }

  @FXML
  public void getSubmapScene() {
    this.textSubmapScene.setText(String.valueOf(gameState_800babc8.submapScene_a4));
  }

  @FXML
  public void setSubmapScene() {
    gameState_800babc8.submapScene_a4 = Integer.valueOf(this.textSubmapScene.getText());
  }

  @FXML
  public void getSubmapCut() {
    this.textSubmapCut.setText(String.valueOf(gameState_800babc8.submapCut_a8));
  }

  @FXML
  public void setSubmapCut() {
    gameState_800babc8.submapCut_a8 = Integer.valueOf(this.textSubmapCut.getText());
  }

  @FXML
  public void getScriptEngine1() {
    this.textScriptEngine1.setText(String.valueOf(gameState_800babc8._b0));
  }

  @FXML
  public void setScriptEngine1() {
    gameState_800babc8._b0 = Integer.valueOf(this.textScriptEngine1.getText());
  }

  @FXML
  public void getScriptEngine2() {
    this.textScriptEngine2.setText(String.valueOf(gameState_800babc8._b4));
  }

  @FXML
  public void setScriptEngine2() {
    gameState_800babc8._b4 = Integer.valueOf(this.textScriptEngine2.getText());
  }

  @FXML
  public void getScriptEngine3() {
    this.textScriptEngine3.setText(String.valueOf(gameState_800babc8._b8));
  }

  @FXML
  public void setScriptEngine3() {
    gameState_800babc8._b8 = Integer.valueOf(this.textScriptEngine3.getText());
  }

  @FXML
  public void getScriptFlags1() {
    this.textScriptFlags1.setText(String.valueOf(gameState_800babc8.scriptFlags2_bc[this.getScriptFlags1.getSelectionModel().getSelectedIndex()]));
  }

  @FXML
  public void setScriptFlags1() {
    gameState_800babc8.scriptFlags2_bc[this.getScriptFlags1.getSelectionModel().getSelectedIndex()] = Integer.valueOf(this.textScriptFlags1.getText());
  }

  @FXML
  public void getScriptFlags2() {
    this.textScriptFlags2.setText(String.valueOf(gameState_800babc8.scriptFlags1_13c[this.getScriptFlags2.getSelectionModel().getSelectedIndex()]));
  }

  @FXML
  public void setScriptFlags2() {
    gameState_800babc8.scriptFlags1_13c[this.getScriptFlags2.getSelectionModel().getSelectedIndex()] = Integer.valueOf(this.textScriptFlags2.getText());
  }

  @FXML
  public void getData2() {
    this.textData2.setText(String.valueOf(gameState_800babc8._15c[this.getData2.getSelectionModel().getSelectedIndex()]));
  }

  @FXML
  public void setData2() {
    gameState_800babc8._15c[this.getData2.getSelectionModel().getSelectedIndex()] = Integer.valueOf(this.textData2.getText());
  }

  @FXML
  public void getData3() {
    this.textData3.setText(String.valueOf(gameState_800babc8._17c[this.getData3.getSelectionModel().getSelectedIndex()]));
  }

  @FXML
  public void setData3() {
    gameState_800babc8._17c[this.getData3.getSelectionModel().getSelectedIndex()] = Integer.valueOf(this.textData3.getText());
  }

  @FXML
  public void getGoods() {
    this.textGoods.setText(String.valueOf(gameState_800babc8.goods_19c[this.getGoods.getSelectionModel().getSelectedIndex()]));
  }

  @FXML
  public void setGoods() {
    gameState_800babc8.goods_19c[this.getGoods.getSelectionModel().getSelectedIndex()] = Integer.valueOf(this.textGoods.getText());
  }

  @FXML
  public void getData4() {
    this.textData4.setText(String.valueOf(gameState_800babc8._17c[this.getData4.getSelectionModel().getSelectedIndex()]));
  }

  @FXML
  public void setData4() {
    gameState_800babc8._17c[this.getData4.getSelectionModel().getSelectedIndex()] = Integer.valueOf(this.textData4.getText());
  }

  @FXML
  public void getChestFlags() {
    this.textChestFlags.setText(String.valueOf(gameState_800babc8._1a4[this.getChestFlags.getSelectionModel().getSelectedIndex()]));
  }

  @FXML
  public void setChestFlags() {
    gameState_800babc8._1a4[this.getChestFlags.getSelectionModel().getSelectedIndex()] = Integer.valueOf(this.textChestFlags.getText());
  }

  public void getEquipment() {
    this.textEquipment.setText(String.valueOf(gameState_800babc8.equipment_1e8.getInt((int)this.getEquipment.getValue())));
  }

  @FXML
  public void setEquipment() {
    gameState_800babc8.equipment_1e8.set((int)this.getEquipment.getValue(), Integer.valueOf(this.textEquipment.getText()));
  }

  public void getItems() {
    this.textItems.setText(String.valueOf(gameState_800babc8.items_2e9.getInt((int)this.getItems.getValue())));
  }

  @FXML
  public void setItems() {
    gameState_800babc8.items_2e9.set((int)this.getItems.getValue(), Integer.valueOf(this.textItems.getText()));
  }

  @FXML
  public void getCharacter() {
    textCharacterData.setText(getCharacterStats());
  }

  @FXML
  public void getCharacterData() {
    textCharacterData.setText(getCharacterStats());
  }

  public String getCharacterStats() {
    String text = "";
    switch(this.getCharacterData.getSelectionModel().getSelectedIndex()) {
      case 0:
        text = String.valueOf(gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].xp_00);
        break;
      case 1:
        text = String.valueOf(gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].partyFlags_04);
        break;
      case 2:
        text = String.valueOf(gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].hp_08);
        break;
      case 3:
        text = String.valueOf(gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].mp_0a);
        break;
      case 4:
        text = String.valueOf(gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].sp_0c);
        break;
      case 5:
        text = String.valueOf(gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].dlevelXp_0e);
        break;
      case 6:
        text = String.valueOf(gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].status_10);
        break;
      case 7:
        text = String.valueOf(gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].level_12);
        break;
      case 8:
        text = String.valueOf(gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].dlevel_13);
        break;
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
        text = String.valueOf(gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].equipment_14[this.getCharacterData.getSelectionModel().getSelectedIndex() - 9]);
        break;
      case 14:
        text = String.valueOf(gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].selectedAddition_19);
        break;
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
        text = String.valueOf(gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].additionLevels_1a[this.getCharacterData.getSelectionModel().getSelectedIndex() - 15]);
        break;
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
        text = String.valueOf(gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].additionXp_22[this.getCharacterData.getSelectionModel().getSelectedIndex() - 23]);
        break;
    }
    return text;
  }

  @FXML
  public void setCharacterData() {
    switch(this.getCharacterData.getSelectionModel().getSelectedIndex()) {
      case 0:
        gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].xp_00 = Integer.valueOf(this.textCharacterData.getText());
        break;
      case 1:
        gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].partyFlags_04 = Integer.valueOf(this.textCharacterData.getText());
        break;
      case 2:
        gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].hp_08 = Integer.valueOf(this.textCharacterData.getText());
        break;
      case 3:
        gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].mp_0a = Integer.valueOf(this.textCharacterData.getText());
        break;
      case 4:
        gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].sp_0c = Integer.valueOf(this.textCharacterData.getText());
        break;
      case 5:
        gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].dlevelXp_0e = Integer.valueOf(this.textCharacterData.getText());
        break;
      case 6:
        gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].status_10 = Integer.valueOf(this.textCharacterData.getText());
        break;
      case 7:
        gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].level_12 = Integer.valueOf(this.textCharacterData.getText());
        break;
      case 8:
        gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].dlevel_13 = Integer.valueOf(this.textCharacterData.getText());
        break;
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
        gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].equipment_14[this.getCharacterData.getSelectionModel().getSelectedIndex() - 9] = Integer.valueOf(this.textCharacterData.getText());
        break;
      case 14:
        gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].selectedAddition_19 = Integer.valueOf(this.textCharacterData.getText());
        break;
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
        gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].additionLevels_1a[this.getCharacterData.getSelectionModel().getSelectedIndex() - 15] = Integer.valueOf(this.textCharacterData.getText());
        break;
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
        gameState_800babc8.charData_32c[this.getCharacter.getSelectionModel().getSelectedIndex()].additionXp_22[this.getCharacterData.getSelectionModel().getSelectedIndex() - 23] = Integer.valueOf(this.textCharacterData.getText());
        break;
    }
  }

  @FXML
  public void getData5() {
    this.textData5.setText(String.valueOf(gameState_800babc8._4b8[this.getData5.getSelectionModel().getSelectedIndex()]));
  }

  @FXML
  public void setData5() {
    gameState_800babc8._4b8[this.getData5.getSelectionModel().getSelectedIndex()] = Integer.valueOf(this.textData5.getText());
  }

  @FXML
  public void getPathIndex() {
    this.textPathIndex.setText(String.valueOf(gameState_800babc8.pathIndex_4d8));
  }

  @FXML
  public void setPathIndex() {
    gameState_800babc8.dotIndex_4da = Integer.valueOf(this.textDotIndex.getText());
  }

  @FXML
  public void getDotIndex() {
    this.textDotIndex.setText(String.valueOf(gameState_800babc8.dotIndex_4da));
  }

  @FXML
  public void setDotIndex() {
    gameState_800babc8.dotIndex_4da = Integer.valueOf(this.textDotIndex.getText());
  }

  @FXML
  public void getDotOffset() {
    this.textDotOffset.setText(String.valueOf(gameState_800babc8.dotOffset_4dc));
  }

  @FXML
  public void setDotOffset() {
    gameState_800babc8.dotOffset_4dc = Integer.valueOf(this.textDotOffset.getText());
  }

  @FXML
  public void getFacing() {
    this.textFacing.setText(String.valueOf(gameState_800babc8.facing_4dd));
  }

  @FXML
  public void setFacing() {
    gameState_800babc8.facing_4dd = Integer.valueOf(this.textFacing.getText());
  }

  @FXML
  public void getAreaIndex() {
    this.textAreaIndex.setText(String.valueOf(gameState_800babc8.areaIndex_4de));
  }

  @FXML
  public void setAreaIndex() {
    gameState_800babc8.areaIndex_4de = Integer.valueOf(this.textAreaIndex.getText());
  }
}
