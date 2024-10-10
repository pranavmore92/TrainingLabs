CREATE TABLE IF NOT EXISTS public.bus_master
(
    id integer NOT NULL,
    agency_name character varying(250) NOT NULL,
    bus_type character varying(150) NOT NULL,
    start_date date NOT NULL,
    from_location character varying(250) NOT NULL,
    to_location character varying(250) NOT NULL,
    bookable_seats integer NOT NULL,
    status character varying(50) NOT NULL,
    created_by character varying(100),
    created_at date,
    CONSTRAINT bus_master_pkey PRIMARY KEY (id)
)