# Changelog

## 0.1.3

### Additions
- (26.1+) New blocks: Pale Oak Palisade and Pale Oak Seat;
- New block/item tag pairs:
  - `copper_bars`;
  - `sky_lanterns`;

### Updates
- Block Box now tags relevant blocks with **Sable** weight tags:
  - `super_light`: Bars and Sky Lanterns;
  - `light`: Palisades and Seats;
- Updated Lapis Lazuli Bricks texture, to alleviate a vertical seam when tiled with itself;
- Updated Stripped Palisade textures across the board, to make the edges of each timber more defined;

### Fixes
- (26.1+) Fixed Spiked Palisades dealing no damage to entities moving on their spikes;

## 0.1.2

### Updates
- (26.1+) Copper Bars have been remapped to Copper Chain Links, due to Minecraft having official Copper Bars now;

### Fixes
- Fix Lapis Lazuli Brick/Mosaic stairs and slabs not being tagged as `mineable/pickaxe`;
- Fix Palisades having wrong render type when Sodium is installed (may be temporary);

### Translations
- Added:
  - fr_fr;

## 0.1.1

### Updates
- Palisades and Seats can now be used as furnace fuel;

### Fixes
- Fix Palisades being tagged as `mineable/pickaxe` due to being tagged as `walls`;
- Fix Nether Palisades using Nether plank sounds, instead of Nether stem sounds;

### Translations
- Removed unneeded `item` lang lines on all translations, as BlockItems use the `block` lang;
- Added:
  - es_mx (thanks, cerealconjugo!);
  - ja_jp (thanks, Abbage230!);
  - ru_ru (thanks, mpustovoi!);
  - uk_ua (thanks, TheGridExpert!);
  - zh_cn (thanks, NumberSir!);

## 0.1.0

Initial release