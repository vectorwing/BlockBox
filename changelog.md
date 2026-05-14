# Changelog

## 0.1.3

### Additions
- (26.1+) New blocks: Pale Oak Palisade and Pale Oak Seat;
- New block/item tag pairs:
  - `copper_bars`;
  - `sky_lanterns`;

### Updates
- Block Box now tags relevant blocks with **Sable** weight tags:
  - `super_light`: Spiked Palisades, Bars and Sky Lanterns;
  - `light`: Palisades and Seats;
  - `slippery`: All blocks in the Packed Ice block set;
  - Sky Lanterns were given `floating_materials` attributes:
    - When assembled, they will float and drift on their own, but are unable to lift anything else but themselves;
    - This is done to not break Aeronautics progression, and because they would be too light to lift anything anyway;
- To allow Sky Lanterns to be hand-pushable under Sable physics, they were given a small amount of mining resistance, no longer being instaminable;
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