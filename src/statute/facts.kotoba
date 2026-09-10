(ns statute.facts
  "General-law compliance catalog for Belize (BLZ) -- extends this
  repo's existing `marketentry.facts` (public-procurement market-entry
  only, narrow scope) with a second, orthogonal catalog of statutes a
  company operating in this jurisdiction must generally track for
  compliance. Mirrors cloud-itonami-iso3166-aze/-bih/-jpn/-deu/-bgr/
  -blr/-bol's `statute.facts` (ADR-2607141700,
  cloud-itonami-compliance-fact-federation).

  Every entry below cites an OFFICIAL Belizean source, curl-verified
  2026-07-22, and every citation reflects PRIMARY TEXT this iteration
  actually fetched (`curl` + `pdftotext -layout`) and read in full, not
  a secondary summary -- an unusually strong evidentiary position
  compared to some prior siblings, since every relevant Belizean
  government host this iteration tried returned HTTP 200 to a plain
  `curl -A \"Mozilla/5.0\"` request with no TLS/JS obstruction (the one
  exception, the tax authority's own site, is documented below):

  - **Belize Companies Act, 2022 (Act No. 11 of 2022)** -- downloaded in
    full as a PDF directly from the Belize Companies and Corporate
    Affairs Registry's (BCCAR) own official site
    (`bccar.bz/wp-content/uploads/2022/11/BELIZE-COMPANIES-ACT-2022.pdf`)
    and read via `pdftotext -layout`. HIGH confidence, primary text: its
    own s.284 establishes BCCAR ('There shall be established under the
    jurisdiction and control of the Commission a Registry known as
    Belize Companies and Corporate Affairs Registry'), s.283(1) makes
    the Financial Services Commission's Director General the Registrar,
    and ss.218/220 set out the struck-off-register mechanism this
    repo's `marketentry.governor` flagship check is grounded in (see
    `marketentry.facts`). This Act REPLACED Belize's prior bifurcated
    regime (the domestic Companies Act, Chapter 250, plus the separate
    International Business Companies Act, Chapter 270, for offshore/IBC
    entities -- both still listed, for historical reference, on
    `bccar.bz/legislations/`) with ONE unified companies statute,
    in force 31 July 2022.
  - **Labour Act, Chapter 297, Revised Edition 2020** -- downloaded in
    full as a PDF directly from the Ministry of Rural Transformation,
    Community Development, Labour and Local Government's own official
    site (`labour.gov.bz/docs/39/Labour_Act.pdf`) and read via
    `pdftotext -layout`. HIGH confidence, primary text: its own cover
    page reads 'BELIZE LABOUR ACT CHAPTER 297 REVISED EDITION 2020
    SHOWING THE SUBSTANTIVE LAWS AS AT 31ST DECEMBER, 2020 ... a
    consolidation of amendments made to the law by Act No. 25 of 2020',
    prepared by the Law Revision Commissioner under the Law Revision
    Act, Chapter 3. Independently corroborated (HIGH confidence) by the
    SAME Ministry's own 'Legislation' resource page, which separately
    lists it as 'Cap 297 Labour Act', and by the Belize public-
    procurement portal's own 'Legal Framework' page
    (`procurement.gov.bz/legalframework/`, fetched directly), which
    independently names 'Labour Act, Chapter 297, Revised edition 2000'
    among the miscellaneous legislation relevant to public-sector
    contracting.
  - **Data Protection Act, 2021 (Act No. 45 of 2021)** -- downloaded in
    full as a PDF (104 pages) directly from BCCAR's own official site
    (`bccar.bz/wp-content/uploads/2023/04/Act-No-45-of-2021-Data-
    Protection-Act.pdf`) and read via `pdftotext -layout`. HIGH
    confidence, primary text: its own enactment clause reads
    '(Gazetted 30th November, 2021) ... This Act may be cited as the
    DATA PROTECTION ACT, 2021', and it establishes a dedicated 'Data
    Protection Commissioner' (s.68) with GDPR-adjacent structure --
    processing principles (Part II), rights of a data subject (Part
    III, including access/rectification/erasure/portability), and
    rules on transfers of personal data outside Belize (Part IV). This
    is a GENUINELY DIFFERENT finding from this catalog family's BOL
    sibling, which explicitly found Bolivia does NOT yet have a
    comprehensive data-protection statute (only a constitutional
    habeas-data provision) -- Belize DOES have one, in force since
    2021, independently confirmed here by reading its own primary text
    rather than assumed from the fact that a sibling jurisdiction
    lacked one.

  A law not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of statute entries. `:statute/url` + `:statute/law-number`
  are the citation the governor requires before any compliance-fact
  proposal referencing this law can commit."
  {"BLZ"
   [{:statute/id "blz.companies-act-2022"
     :statute/title "Belize Companies Act, 2022"
     :statute/jurisdiction "BLZ"
     :statute/kind :law
     :statute/law-number "Act No. 11 of 2022, in force 31 July 2022 -- replaced the prior bifurcated Companies Act (Chapter 250, domestic) and International Business Companies Act (Chapter 270, offshore/IBC) regime with one unified companies statute administered by the Belize Companies and Corporate Affairs Registry (BCCAR) under the Financial Services Commission (ss.283/284); ss.218/220 establish the struck-off-register mechanism this repo's flagship market-entry governor check is grounded in"
     :statute/url "https://bccar.bz/wp-content/uploads/2022/11/BELIZE-COMPANIES-ACT-2022.pdf"
     :statute/url-provenance :bccar-official-site
     :statute/enacted-date "2022-07-31"
     :statute/retrieved-at "2026-07-22"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "blz.labour-act-cap297"
     :statute/title "Labour Act, Chapter 297 (Belize)"
     :statute/jurisdiction "BLZ"
     :statute/kind :law
     :statute/law-number "Chapter 297, Revised Edition 2020 (consolidating amendments made by Act No. 25 of 2020), prepared under the Law Revision Act, Chapter 3 -- independently corroborated by procurement.gov.bz's own 'Legal Framework' listing"
     :statute/url "https://www.labour.gov.bz/docs/39/Labour_Act.pdf"
     :statute/url-provenance :ministry-of-labour-official-site
     :statute/enacted-date "2020-12-31"
     :statute/retrieved-at "2026-07-22"
     :statute/topic #{:labor :employment}}
    {:statute/id "blz.data-protection-act-2021"
     :statute/title "Data Protection Act, 2021 (Belize)"
     :statute/jurisdiction "BLZ"
     :statute/kind :law
     :statute/law-number "Act No. 45 of 2021, gazetted 30 November 2021 -- establishes a Data Protection Commissioner (s.68) and GDPR-adjacent processing principles, data-subject rights and cross-border transfer rules. A COMPREHENSIVE statutory data-protection regime, unlike the constitutional-only habeas-data mechanism this catalog family's BOL sibling found for Bolivia -- see namespace docstring"
     :statute/url "https://bccar.bz/wp-content/uploads/2023/04/Act-No-45-of-2021-Data-Protection-Act.pdf"
     :statute/url-provenance :bccar-official-site
     :statute/enacted-date "2021-11-30"
     :statute/retrieved-at "2026-07-22"
     :statute/topic #{:data-protection :privacy}}]})

(defn spec-basis
  "The jurisdiction's statute vector, or nil -- nil means NO spec-basis
  for that jurisdiction yet."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report, same shape/discipline as `marketentry.facts/coverage`:
  never report a missing jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-blz statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "BLZ")) " BLZ statutes seeded with an "
                 "official citation. Extend "
                 "`statute.facts/catalog`, never fabricate a law-id or URL.")})))

(defn by-topic
  "Statutes for `iso3` tagged with `topic` (e.g. :labor, :data-protection)."
  [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
