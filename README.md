# Indonesian IPTV Extension for CloudStream

Extension untuk CloudStream yang menyediakan akses ke channel TV Indonesia secara gratis.

## Features

- **TV Nasional**: RCTI, SCTV, ANTV, Indosiar, Trans TV, Trans7, Metro TV, tvOne, GTV, MNC TV, iNews, BTV
- **TV Berita**: Kompas TV, CNN Indonesia, CNBC Indonesia
- **TV Olahraga**: TVRI Sport, Sportstars
- **TV Anak**: RTV, MNC TV
- **TV Religi**: Rodja TV, TV Al-Quran
- **TV Daerah**: JTV, Bali TV
- **TV Internasional**: BBC World News, CNN International, Al Jazeera, NHK World, DW, France 24

## Installation

1. Buka CloudStream
2. Buka Settings → Extensions → Add Repository
3. Masukkan URL: `https://raw.githubusercontent.com/username/IPTV-extension/main/repo.json`
4. Install extension "Indonesian IPTV"

## Building Locally

```bash
# Clone repository
git clone https://github.com/username/IPTV-extension.git
cd IPTV-extension

# Build provider
./gradlew IndonesianIPTVProvider:make
```

## Sources

- [iptv-org/iptv](https://github.com/iptv-org/iptv)
- [riotryulianto/iptv-playlists](https://github.com/riotryulianto/iptv-playlists)
- Official streaming websites

## License

Public Domain - Free to use
