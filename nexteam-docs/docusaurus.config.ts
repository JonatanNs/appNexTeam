import { themes as prismThemes } from 'prism-react-renderer';
import type { Config } from '@docusaurus/types';
import type * as Preset from '@docusaurus/preset-classic';

// This runs in Node.js - Don't use client-side code here (browser APIs, JSX...)

const config: Config = {
  title: 'NexTeam',
  tagline: "L'intranet nouvelle génération qui unifie vos équipes.",
  favicon: 'img/logo_nexteam.png',

  // Future flags, see https://docusaurus.io/docs/api/docusaurus-config#future
  future: {
    v4: true, // Improve compatibility with the upcoming Docusaurus v4
  },

  url: 'https://JonatanNs.github.io',
  baseUrl: '/appNexTeam/',

  organizationName: 'JonatanNs',
  projectName: 'appNexTeam',
  deploymentBranch: 'gh-pages',

  onBrokenLinks: 'throw',

  
  i18n: {
    defaultLocale: 'fr',
    locales: ['fr'],
  },

  presets: [
    [
      'classic',
      {
        docs: {
          sidebarPath: './sidebars.ts',
        },
        blog: {
          showReadingTime: true,
          feedOptions: {
            type: ['rss', 'atom'],
            xslt: true,
          },
          onInlineTags: 'warn',
          onInlineAuthors: 'warn',
          onUntruncatedBlogPosts: 'warn',
        },
        theme: {
          customCss: './src/css/custom.css',
        },
      } satisfies Preset.Options,
    ],
  ],

  themeConfig: {
    image: 'img/logo_nexteam.png',
    colorMode: {
      respectPrefersColorScheme: true,
    },
    navbar: {
      title: 'NexTeam',
      logo: {
        alt: 'My Site Logo',
        src: 'img/logo_nexteam.png',
      },
      items: [
        {
          type: 'docSidebar',
          sidebarId: 'tutorialSidebar',
          position: 'left',
          label: 'Préparation du projet',
        },
        {
          label: 'Cahier des charges',
          to: '/docs/cahierDesCharges',
        },
        
        {
          href: 'https://github.com/JonatanNs/appNexTeam',
          label: 'GitHub',
          position: 'right',
        },
      ],
    },
    footer: {
      style: 'dark',
      links: [
        {
          title: 'Docs',
          items: [
            {
              label: 'Préparation du projet',
              to: '/docs/preparation',
            },
            {
              label: 'Cahier des charges',
              to: '/docs/cahierDesCharges',
            },
            
            
          ],
        },
        {
          title: 'Community',
          items: [
            {
              label: 'Linkedin',
              href: 'https://www.linkedin.com/in/jonatan-nsualu/',
            },
            {
              label: 'GitHub',
              href: 'https://github.com/JonatanNs/appNexTeam',
            },
          ],
        },
      ],
      copyright: `Copyright © ${new Date().getFullYear()} NexTeam, Inc.`,
    },
    prism: {
      theme: prismThemes.github,
      darkTheme: prismThemes.dracula,
    },
  } satisfies Preset.ThemeConfig,
};

export default config;
