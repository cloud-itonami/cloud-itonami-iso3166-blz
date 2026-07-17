(ns culture.facts
  "Country-level regional-culture catalog for Belize (BLZ) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"BLZ"
   [{:culture/id "blz.dish.fry-jack"
     :culture/name "Fry jack"
     :culture/country "BLZ"
     :culture/kind :dish
     :culture/summary "Deep-fried dough pieces shaped as circles or triangles, a traditional breakfast dish in Belizean cuisine."
     :culture/url "https://en.wikipedia.org/wiki/Fry_jack"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "blz.dish.bile-up"
     :culture/name "Bile up"
     :culture/country "BLZ"
     :culture/kind :dish
     :culture/summary "Combination of boiled eggs, fish or pig tail with ground foods such as cassava, green plantains, yams and sweet potatoes; considered the cultural dish of the Belizean Kriols."
     :culture/url "https://en.wikipedia.org/wiki/Belizean_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "blz.dish.rice-and-beans"
     :culture/name "Rice and beans"
     :culture/country "BLZ"
     :culture/kind :dish
     :culture/summary "Listed among the traditional staple dishes of Belizean cuisine, alongside stew chicken, tamales, panades and garnaches."
     :culture/url "https://en.wikipedia.org/wiki/Belizean_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "blz.beverage.belikin"
     :culture/name "Belikin"
     :culture/country "BLZ"
     :culture/kind :beverage
     :culture/summary "Beer produced by the Belize Brewing Company, founded in 1969 and headquartered in Ladyville, Belize; the name is an amalgamation of several Mayan words."
     :culture/url "https://en.wikipedia.org/wiki/Belikin"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "blz.product.marie-sharps"
     :culture/name "Marie Sharp's"
     :culture/country "BLZ"
     :culture/kind :product
     :culture/summary "Condiment and jam manufacturer based in the Stann Creek District of Belize, famous for habanero hot sauces; the first commercially successful agricultural product manufactured in and exported from Belize."
     :culture/url "https://en.wikipedia.org/wiki/Marie_Sharp%27s"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "blz.festival.garifuna-settlement-day"
     :culture/name "Garifuna Settlement Day"
     :culture/country "BLZ"
     :culture/kind :festival
     :culture/summary "Public holiday in Belize celebrated each year on November 19, commemorating the settlement of the Garifuna people in Belize; major festivities with parades, street music and traditional dancing occur in Dangriga."
     :culture/url "https://en.wikipedia.org/wiki/Garifuna_Settlement_Day"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "blz.heritage.belize-barrier-reef"
     :culture/name "Belize Barrier Reef"
     :culture/country "BLZ"
     :culture/kind :heritage
     :culture/summary "300-kilometre section of the Mesoamerican Barrier Reef System along the coast of Belize, part of the second largest coral reef system in the world; the reserve system was designated a UNESCO World Heritage Site in 1996."
     :culture/url "https://en.wikipedia.org/wiki/Belize_Barrier_Reef"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "blz.heritage.caracol"
     :culture/name "Caracol"
     :culture/name-local "Uxwitza'"
     :culture/country "BLZ"
     :culture/kind :heritage
     :culture/summary "Large ancient Maya archaeological site in the Cayo District of Belize, one of the most important regional political centers of the Maya Lowlands during the Classic Period."
     :culture/url "https://en.wikipedia.org/wiki/Caracol"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-blz culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "BLZ"))
                 " BLZ entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
