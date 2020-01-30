--
-- PostgreSQL database dump
--


CREATE TABLE public.emprunt (
    id integer NOT NULL,
    date_debut date NOT NULL,
    date_fin date NOT NULL,
    prolongation boolean NOT NULL,
    membreid integer NOT NULL,
    exemplaireid integer NOT NULL,
    relance boolean,
    termine boolean
);


ALTER TABLE public.emprunt OWNER TO postgres;



CREATE SEQUENCE public.emprunt_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
    CYCLE;


ALTER TABLE public.emprunt_id_seq OWNER TO postgres;



ALTER SEQUENCE public.emprunt_id_seq OWNED BY public.emprunt.id;




CREATE TABLE public.exemplaire (
    id integer NOT NULL,
    disponibilite boolean NOT NULL,
    livreid integer NOT NULL
);


ALTER TABLE public.exemplaire OWNER TO postgres;



CREATE SEQUENCE public.exemplaire_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
    CYCLE;


ALTER TABLE public.exemplaire_id_seq OWNER TO postgres;



ALTER SEQUENCE public.exemplaire_id_seq OWNED BY public.exemplaire.id;



CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;



CREATE TABLE public.livre (
    id integer NOT NULL,
    titre character varying(255) NOT NULL,
    auteur character varying(255) NOT NULL,
    genre character varying(255) NOT NULL,
    date_publication date NOT NULL,
    resume character varying(2000) NOT NULL,
    url_photo character varying(500)
);


ALTER TABLE public.livre OWNER TO postgres;



CREATE SEQUENCE public.livre_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
    CYCLE;


ALTER TABLE public.livre_id_seq OWNER TO postgres;



ALTER SEQUENCE public.livre_id_seq OWNED BY public.livre.id;



CREATE TABLE public.membre (
    id integer NOT NULL,
    nom character varying(255) NOT NULL,
    prenom character varying(255) NOT NULL,
    adresse_mail character varying(255) NOT NULL,
    mot_de_passe character varying(255) NOT NULL,
    telephone character varying(255) NOT NULL,
    adresse character varying(255) NOT NULL,
    code_postal character varying(255) NOT NULL,
    ville character varying(255) NOT NULL
);


ALTER TABLE public.membre OWNER TO postgres;



CREATE SEQUENCE public.membre_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
    CYCLE;


ALTER TABLE public.membre_id_seq OWNER TO postgres;
ALTER SEQUENCE public.membre_id_seq OWNED BY public.membre.id;
ALTER TABLE ONLY public.emprunt ALTER COLUMN id SET DEFAULT nextval('public.emprunt_id_seq'::regclass);
ALTER TABLE ONLY public.exemplaire ALTER COLUMN id SET DEFAULT nextval('public.exemplaire_id_seq'::regclass);
ALTER TABLE ONLY public.livre ALTER COLUMN id SET DEFAULT nextval('public.livre_id_seq'::regclass);
ALTER TABLE ONLY public.membre ALTER COLUMN id SET DEFAULT nextval('public.membre_id_seq'::regclass);




ALTER TABLE ONLY public.emprunt
    ADD CONSTRAINT emprunt_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.exemplaire
    ADD CONSTRAINT exemplaire_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.livre
    ADD CONSTRAINT livre_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.membre
    ADD CONSTRAINT membre_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.emprunt
    ADD CONSTRAINT fkemprunt253495 FOREIGN KEY (membreid) REFERENCES public.membre(id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE ONLY public.emprunt
    ADD CONSTRAINT fkemprunt552415 FOREIGN KEY (exemplaireid) REFERENCES public.exemplaire(id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE ONLY public.exemplaire
    ADD CONSTRAINT fkexemplaire511617 FOREIGN KEY (livreid) REFERENCES public.livre(id) ON UPDATE CASCADE ON DELETE CASCADE;




