document.addEventListener("DOMContentLoaded", () => {
  const includeElements = document.querySelectorAll('[include-html]');
  includeElements.forEach(async (el) => {
    const file = el.getAttribute("include-html");
    try {
      const res = await fetch(file);
      if (!res.ok) throw new Error(`파일을 불러올 수 없습니다: ${file}`);
      const html = await res.text();
      el.innerHTML = html;
    } catch (err) {
      el.innerHTML = `<p style="color:red;">${err.message}</p>`;
    }
  });
});
