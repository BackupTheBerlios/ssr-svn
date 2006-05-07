<!--
	Per inserire un url a una sottopagina:
	<a href="index.php?browse=code&amp;subtopic=$nomesottopagina">Vai alla sottopagina</a>
	
	deve esistere un file sottopagina.inc.php con i contenuti e il seguente codice:
	/* <?php
	include_once('inc/defs.inc.php');
	?> */
-->
<h3>Repository Subversion</h3>
<p>Il codice è organizzato mediante <a href="http://it.wikipedia.org/wiki/Subversion">subversion</a>, un sistema di controllo di versione. Il codice del repository è il più aggiornato, ma può essere non funzionante o instabile. L'indirizzo del repository è</p>
<ul>
	<li><code>svn://svn.berlios.de/ssr/trunk</code></li>
	<li><a href="http://svn.berlios.de/wsvn/ssr">consulta il repository via web</a>.</li>
</ul>

<p>Nella directory <code>trunk</code> sono presenti due sottodirectory</p>
<ul>
   <li><code>SongShuffler</code> contiene il progetto e i javadoc;</li>
   <li><code>htdocs</code> contiene il codice di questo sito.</li>
</ul>

<h3>Scaricare il codice sorgente.</h3>
<p>Utilizzando un client svn è sufficiente creare una directory con nome a piacere (ad esempio <code>songshuffler</code>), posizionarsi al suo interno e dare sul terminale uno dei seguenti comandi:</p>
<ul>
	<li><code>svn checkout svn://svn.berlios.de/ssr/trunk</code><br />per scaricare tutto il repository</li>
	<li><code>svn checkout svn://svn.berlios.de/ssr/trunk/SongShuffler</code><br />per scaricare solo il codice di SongShuffler</li>
	<li><code>svn checkout svn://svn.berlios.de/ssr/trunk/htdocs</code><br />per scaricare il codice del sito</li>
	<li><code>svn checkout svn://svn.berlios.de/ssr/SongShuffler/doc</code><br />per scaricare solamente i javadoc di SongShuffler</li>
</ul>

<p>Per mantenere sincronizzato il codice dare il comando</p>
<ul>
	<li><code>svn update</code></li>
</ul>
<p>all'interno della directory.</p>

<h4>Con windows</h4>
<p>Per windows esiste <a href="http://tortoisesvn.tigris.org/">TortoiseSVN</a>. Dopo averlo installato</p>
<ul>
	<li>create una cartella con nome a piacere</li>
	<li>cliccateci sopra con il tasto destro</li>
	<li>scegliete <code>SVN Checkout</code> dal nuovo sottomenu <code>TortoiseSVN</code></li>
	<li>inserite l'indirizzo <code>svn://svn.berlios.de/ssr/trunk</code></li>
	<li>se chiede il login scegliete di essere anonimi e attendere lo scaricamento</li>
</ul>
