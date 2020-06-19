Brak **ekstensji** ze względu na charakter aplikacji - webowa.

Brak **asocjacji kwalifikowanej** ze względu na relację bazodanową (`fetchByNumber()`).

Brak metody `generate` (**polimorfizm**) ze względu na możliwość wygenerowania dokumentu w formie HTML.

Puste konstruktory ponieważ: 
```
No default constructor for entity:  : archorganizer.model.document.state.Draft
``` 

Niestety `Attachment` powinien mieć `Stage` - zmieniono.