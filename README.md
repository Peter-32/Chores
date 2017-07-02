# chores

This is a backup of our house chores.  The purpose is to determine who should do which chore for the month.

## A common query to use:

select b.firstname, upstairs AS upstair, bathroom_num AS bath_num,
                    SUM(IF(chore_dim_id IN (2,3,4,5),1,0)) / max(d.total_chores) AS uncom,
                    SUM(IF(chore_dim_id=5,1,0)) / max(d.total_chores) AS bathr,
                    SUM(IF(chore_dim_id=4,1,0)) / max(d.total_chores) AS outside,
                    SUM(IF(chore_dim_id=2,1,0)) / max(d.total_chores) AS c_area,
                    SUM(IF(chore_dim_id=3,1,0)) / max(d.total_chores) AS trash,
                    SUM(IF(chore_dim_id=1,1,0)) / max(d.total_chores) AS kitch,
                     max(d.total_chores) AS months
                    from monthly_chore a
                    INNER JOIN member b on b.id = a.member_id
                    INNER JOIN chore_dim c on c.id = a.chore_dim_id
                    INNER JOIN (select member_id, count(*) total_chores from monthly_chore group by 1) d on d.member_id = a.member_id
                    group by 1,2,3
                    order by uncom asc, bathr asc, outside asc, c_area asc
