SELECT MAX(Antall) AS Antall, Kategori, Selskap FROM
(
    SELECT COUNT(t.tittel) AS Antall, k.navn AS Kategori, s.navn AS Selskap
    FROM Tittel_i_kategori AS tik
    JOIN Kategorier AS k ON tik.kategori_id = k.id
    JOIN Titler AS t ON tik.tittel_id = t.id
    JOIN Selskaper AS s ON t.utgiver_id = s.id
    GROUP BY Kategori, Selskap
    ORDER BY s.navn
) AS foo # Subqueries must have an alias when used like this
GROUP BY Kategori;
