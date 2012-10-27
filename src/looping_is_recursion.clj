(ns looping-is-recursion)

(defn singleton?
    "Tarkistaa onko kokoelma yhden kokoinen"
    [coll]
    (if (empty? coll)
              false
              (= (rest coll) '())))


(defn power 
  "Korotetaan base potenssiin exp"
  [base exp]
  (let [helper (fn [acc base xp]
                 (cond
                   (= 1 xp) acc
                   (= 0 xp) 1
                   :else (recur (* acc base) base (dec xp))))]
    (helper base base exp)))

(defn last-element [a-seq]
  "Palautetaan sekvenssin viimeinen elementti"
  (let [helper (fn [a-seq]
                 (cond
                   (empty? a-seq) nil
                   (singleton? a-seq) (first a-seq)
                   :else (recur (rest a-seq))))]
    (helper a-seq)))

(defn seq= [seq1 seq2]
  "Tutkitaan ovatko kaksi sekvenssiä samankokoiset"
  (loop [x seq1 y seq2]
        (cond 
          (and (empty? x) (empty? y)) true
          (or (empty? x) (empty? y)) false
          :else (recur (rest x) (rest y)))))

(defn find-first-index
 "Palautetaan sen elementin indeksi, jolla pred on true ensi kertaa"
  [pred a-seq]
  (loop [acc 0
         p? pred
         seq1 a-seq]
       (cond
         (empty? seq1) nil
         (p? (first seq1)) acc
         :else (recur 
                 (inc acc) 
                 p? 
                 (rest seq1)))))

(defn avg
 "Lasketaan sekvenssin elementtien keskiarvo. Sori että tää on tällainen hirviö, yritin toisenlaisiakin lähestymistapoja, mutta tämä oli nyt ainoa jonka sain toimimaan ylipäätään."
  [a-seq]

  (loop [jako (count a-seq)
         in (count a-seq)
         acc 0
         seq1 a-seq]

     (cond
      (= in 0) nil
      (= in 1) (/ (+ acc (first seq1)) jako)
      :else (recur jako 
                   (dec in) 
                   (+ acc 
                      (first seq1)) 
                   (rest seq1)))))
 ; (if (empty? a-seq)
 ;   '()
 ;   (/ (loop [summa 0
 ;             jono a-seq]
 ;        (if (empty? a-seq)
  ;         summa
  ;         (recur (+ summa (first a-seq))
   ;               (rest a-seq))))
    ;   (count a-seq))))


 (defn parity [a-seq]
;  (loop [seq1 a-seq in (count a-seq)]
;    (cond
;      (= in 0) {}
;      ()
;      :else)))
   '() )

(defn fast-fibo [n]
 ; (loop [fn1 fn0]
  ;  (cond))
     [":("] )

(defn cut-at-repetition [a-seq]
  [":("])

