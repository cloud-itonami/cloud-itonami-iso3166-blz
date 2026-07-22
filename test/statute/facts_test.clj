(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest blz-has-spec-basis
  (let [sb (facts/spec-basis "BLZ")]
    (is (= 3 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "https://") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["BLZ" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["blz.labour-act-cap297"]
         (mapv :statute/id (facts/by-topic "BLZ" :labor))))
  (is (= ["blz.data-protection-act-2021"]
         (mapv :statute/id (facts/by-topic "BLZ" :data-protection))))
  (is (empty? (facts/by-topic "BLZ" :environment)))
  (is (empty? (facts/by-topic "ATL" :labor))))
