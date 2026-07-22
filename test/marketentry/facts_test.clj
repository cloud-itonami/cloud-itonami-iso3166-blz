(ns marketentry.facts-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.facts :as facts]))

(deftest blz-has-spec-basis
  (let [sb (facts/spec-basis "BLZ")]
    (is (some? sb))
    (is (string? (:provenance sb)))
    (is (seq (:required-evidence sb)))
    (is (some? (facts/corporate-number-spec-basis "BLZ")))
    (is (some? (facts/business-registration-spec-basis "BLZ")))
    (is (some? (facts/struck-off-spec-basis "BLZ")))))

(deftest blz-rep-spec-basis-is-honestly-absent
  (testing "no verified resident/local-representative mandate for BLZ public-procurement bid participation specifically -- deliberately not claimed"
    (is (nil? (facts/rep-spec-basis "BLZ")))))

(deftest blz-business-registration-is-a-separate-body-from-tax-and-procurement
  (testing "business registration (BCCAR, under the Financial Services Commission) is a DIFFERENT body than the tax registrar (BTS) and the procurement regulator (Procurement Unit/MOF) -- see namespace docstring"
    (let [reg (facts/business-registration-spec-basis "BLZ")
          tax (facts/corporate-number-spec-basis "BLZ")]
      (is (some? reg))
      (is (some? tax))
      (is (not= (:business-registration-owner-authority reg)
                (:corporate-number-owner-authority tax))))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ")))
  (is (nil? (facts/business-registration-spec-basis "ATL")))
  (is (nil? (facts/struck-off-spec-basis "ATL"))))

(deftest required-evidence-satisfied
  (let [sb (facts/spec-basis "BLZ")
        all (:required-evidence sb)]
    (is (true? (facts/required-evidence-satisfied? "BLZ" all)))
    (is (not (facts/required-evidence-satisfied? "BLZ" (take 1 all))))
    (is (nil? (facts/required-evidence-satisfied? "ATL" all)))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["BLZ" "USA" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 2 (:covered c)))
    (is (= ["ATL"] (:missing-jurisdictions c)))))
