# hibernate-auto-table-creation

1. Master branch - simple auto generation of one table from entity schema.

2. Branch for custom id generation for PK along with auto generation of table from entity (does not work with GenerationType.IDENTITY).
https://github.com/@GeneratedValue(strategy = GenerationType.IDENTITY )sandeepan-nath/hibernate-auto-table-creation/tree/auto_gen_table_and_custom_id_gen

3. Branch auto_gen_tables_one_to_one - Two tables with OneToOne mapping. Both entities have @GeneratedValue(strategy = GenerationType.IDENTITY ) and type Integer. No custom ID generation case.
