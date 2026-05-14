# Changelog

## 0.1.3

### Additions
- New block/item tag pairs:
  - `copper_bars`;
  - `sky_lanterns`;

### Updates
- Block Box now tags relevant blocks with **Sable** weight tags:
  - `super_light`: Spiked Palisades, Bars and Sky Lanterns;
  - `light`: Palisades and Seats;
  - `slippery`: All blocks in the Packed Ice block set;
- Updated Lapis Lazuli Bricks texture, to alleviate a vertical seam when tiled with itself;
- Updated Stripped Palisade textures across the board, to make the edges of each timber more defined;

## 0.1.2

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