# Business Model: Independent Public-Sector Market-Entry & Procurement Compliance Service — Belize

## Classification

- Repository: `cloud-itonami-iso3166-blz`
- ISO 3166: `BLZ` (Belize)
- Activity: public-procurement market-entry and ongoing regulatory-
  compliance navigation for an already-incorporated operator
- Social impact: [:belizean-sme-market-access :public-spend-transparency :cross-border-friction-reduction]

## Customer

- an already-incorporated `cloud-itonami-cofog-{code}` /
  `cloud-itonami-isco-{code}` / `cloud-itonami-unspsc-{segment}` /
  `cloud-itonami-{ISIC}` operator wanting to bid on a Belizean
  public contract
- a foreign SME or civic-tech vendor entering the public sector in
  Belize for the first time
- a `cloud-itonami-M6910` client that has just completed incorporation and
  now needs public-sector market access

## Offer

- registration walkthrough for procurement.gov.bz, Belize's centralized
  public-procurement notices/opportunities portal, administered by the
  Procurement Unit of the Ministry of Finance and connected to the
  CARICOM-wide Public Procurement Notice Board -- covering goods, works,
  services and consulting opportunities from government ministries,
  departments and public bodies
- vendor (supplier) registration walkthrough: unlike a single central
  supplier registry, Belize's own registration process is
  PER-PROCURING-ENTITY -- a Vendor Authorization Form (Persons P1 /
  Businesses B1) is submitted directly to the contracting public entity
  for entry into the government's SmartStream accounting system (per
  procurement.gov.bz's own "Supplier (Vendor) Registration Process"
  page); this service helps an operator navigate that per-entity process
- business/tax registration checklist: an active Belize Companies and
  Corporate Affairs Registry (BCCAR) registration in GOOD STANDING (not
  struck off under Belize Companies Act, 2022 s.220), BCCAR being
  administered by the Financial Services Commission (FSC) per the
  Belize Companies Act, 2022 (Act No. 11 of 2022) -- a UNIFIED registry
  that in 2022 replaced Belize's prior bifurcated regime (the domestic
  Companies Act Chapter 250 plus the separate International Business
  Companies Act Chapter 270 for offshore/IBC entities); plus a Belize
  Tax Service (BTS) tax registration, a SEPARATE act administered by
  the Ministry of Finance's own Revenue & Tax Administration function --
  see `src/marketentry/facts.cljc` and `src/statute/facts.cljc` for the
  full citation trail, including the explicit, honest gap on BTS's own
  specific enabling legislation (bts.gov.bz serves its content via a
  client-rendered SPA this iteration could not fetch)
- struck-off-register monitoring: an operator whose registered company
  falls out of good standing on BCCAR (annual-fee non-payment, failure
  to file required returns, etc., per Belize Companies Act 2022 s.218)
  is categorically barred, under s.220, from carrying on ANY business --
  this service flags that risk before it becomes a HARD hold on a real
  filing submission
- local-content / preferential-procurement navigation, where applicable
  on qualifying Belizean tenders
- ongoing regulatory-change monitoring subscription
- compliance-audit export package for the client's own records

## Revenue

- per-engagement market-entry fee (one-time registration + checklist
  completion)
- recurring regulatory-change monitoring subscription
- compliance-audit export package

## Trust Controls

- any actual portal registration or filing submission requires
  Market-Entry Compliance Governor clearance and always escalates to
  human sign-off (`:filing/submit` is never automated at any phase)
- a false or fabricated regulatory-requirement claim is a HARD hold that
  cannot be overridden by human approval alone — it must be corrected
  against a cited official source first
- this service does **not** provide legal or tax advice; characterization
  and filing on the client's behalf beyond checklist/draft assistance
  routes to Belizean-licensed counsel or a registered agent
- every requirement cites the official portal or regulation, never
  invented

## Boundary with adjacent actors (read before forking)

- **`com-etzhayyim-ooyake`** (etzhayyim/root): read-only civic-wayfinding
  mirror of government structure, non-commercial, barred from acting as
  or for the government (G3 impersonation ban). This blueprint is
  commercial and never claims to be an official channel.
- **`matsurigoto`** (etzhayyim/root): sovereign e-government statecraft —
  literally the government, for etzhayyim's own covenant or an adopting
  nation-state. This blueprint is an independent operator the government
  contracts with or that bids into its procurement — never the
  government.
- **`com-etzhayyim-toritsugi`** (etzhayyim/root): guides a consenting
  INDIVIDUAL citizen through their OWN procedure, non-profit,
  donation-only. This blueprint's client is a business operator, not an
  individual citizen, and it is commercial.
- **`legal-entity.etzhayyim.com`**: read-only aggregated company-registry
  data, no execution. This blueprint executes (gated) registrations.
- **`cloud-itonami-M6910`**: helps a client BECOME a legal entity
  (incorporation, ISIC 6910) — a prior, different regulatory phase
  (company law). This blueprint assumes incorporation is already done and
  handles public-procurement market entry (a different regulatory domain).
- **`cloud-itonami-cofog-{code}`**: a jurisdiction-agnostic operator
  template for ONE public function. This blueprint is the orthogonal
  jurisdiction-specific axis — the two compose (fork a COFOG-function
  blueprint AND this one to operate in Belize).
