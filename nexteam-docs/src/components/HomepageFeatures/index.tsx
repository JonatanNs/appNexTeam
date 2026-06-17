import React from 'react';
import clsx from 'clsx';
import Layout from '@theme/Layout';
import Link from '@docusaurus/Link';
import styles from './styles.module.css';
import { faUsers, faCode, faLaptopCode, faServer, faDatabase, faShieldHalved, faListCheck, faComments, faBullseye, faUser } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

export default function Home(): React.ReactNode {
  return (
    <>
      <main>

        <section className={styles.section}>
          <div className="container">

            <div className={styles.sectionHeader}>
              <FontAwesomeIcon icon={faUsers} />
              <h2>À propos</h2>
            </div>

            <div className={styles.card}>
              <p>
                NexTeam est une plateforme intranet moderne permettant de centraliser
                la communication, les informations et les outils internes de
                l'entreprise.
              </p>
            </div>

          </div>
        </section>

        <section className={styles.sectionAlt}>
          <div className="container">

            <div className={styles.sectionHeader}>
              <FontAwesomeIcon icon={faCode} />
              <h2>Stack technique</h2>
            </div>

            <div className={styles.grid}>

              <div className={styles.techCard}>
                <FontAwesomeIcon icon={faLaptopCode} />
                <span>Angular 21</span>
              </div>

              <div className={styles.techCard}>
                <FontAwesomeIcon icon={faServer} />
                <span>Spring Boot 3</span>
              </div>

              <div className={styles.techCard}>
                <FontAwesomeIcon icon={faDatabase} />
                <span>PostgreSQL</span>
              </div>

              <div className={styles.techCard}>
                <FontAwesomeIcon icon={faShieldHalved} />
                <span>JWT Security</span>
              </div>

            </div>

          </div>
        </section>

        <section className={styles.section}>
          <div className="container">

            <div className={styles.sectionHeader}>
              <FontAwesomeIcon icon={faListCheck} />
              <h2>Fonctionnalités</h2>
            </div>

            <div className={styles.featureGrid}>

              <div className={styles.featureCard}>
                <FontAwesomeIcon icon={faComments} />
                <h3>Communication</h3>
                <p>Messagerie temps réel et fil d'actualité.</p>
              </div>

              <div className={styles.featureCard}>
                <FontAwesomeIcon icon={faListCheck} />
                <h3>Organisation</h3>
                <p>Gestion des tâches et suivi des missions.</p>
              </div>

              <div className={styles.featureCard}>
                <FontAwesomeIcon icon={faShieldHalved} />
                <h3>Sécurité</h3>
                <p>JWT, rôles utilisateurs et BCrypt.</p>
              </div>

            </div>

          </div>
        </section>

        <section className={styles.sectionAlt}>
          <div className="container">

            <div className={styles.sectionHeader}>
              <FontAwesomeIcon icon={faBullseye} />
              <h2>Objectif</h2>
            </div>

            <div className={styles.card}>
              <p>
                Réduire la fragmentation des outils internes et améliorer la
                collaboration grâce à une plateforme centralisée.
              </p>
            </div>

          </div>
        </section>

        <section className={styles.section}>
          <div className="container">

            <div className={styles.sectionHeader}>
              <FontAwesomeIcon icon={faUser} />
              <h2>Auteur</h2>
            </div>

            <div className={styles.card}>
              <p>
                <strong>Jonatan NS</strong><br />
                Développeur Fullstack Java / Angular
              </p>
            </div>

          </div>
        </section>

      </main>
    </>
  );
}